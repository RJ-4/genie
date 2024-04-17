package com.naehas.genie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.genie.constant.ErrorMessageConstants;
import com.naehas.genie.dto.request.FileRequestDTO;
import com.naehas.genie.dto.response.FileResponseDTO;
import com.naehas.genie.entity.File;
import com.naehas.genie.exception.InvalidInputException;
import com.naehas.genie.mapper.FileMapper;
import com.naehas.genie.repository.FileRepository;
import com.naehas.genie.service.FileService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileMapper fileMapper;

    @Override
    public FileResponseDTO createFile(FileRequestDTO fileRequestDto) throws InvalidInputException {
    	
        Long userId = fileRequestDto.getUserId();

        String name = fileRequestDto.getName();
        Long parentFileId = fileRequestDto.getParentFileId();
        this.validateDuplicateFile(name, parentFileId);

        log.info("Creating an file with name: " + name + " and parent file id:" + parentFileId);

        File parentFile = this.getFile(parentFileId);
        
        File file = fileMapper.mapToFile(fileRequestDto, parentFile, userId);

        file = fileRepository.save(file);

        log.info("File with name: " + name + " created successfully with id: " + file.getId());

        FileResponseDTO fileResponseDTO = fileMapper.mapToNewFileResponseDTO(file);

        return fileResponseDTO;


    }

    /**
     * 
     * @param id
     * @return
     * @throws InvalidInputException
     */
    private File getFile(Long id) throws InvalidInputException {
    	
    	log.info("Retrieving file with id: {}", id);
    	
    	String errorMessge = "File with id: " + id + " does not exist";
    	
    	File file = fileRepository.findById(id)
								 .orElseThrow(() -> new InvalidInputException(String.format(ErrorMessageConstants.ERROR_FILE_ID_NOT_EXISTS, "" + id), errorMessge));
    	
    							  
    	
    	log.info("Successfully retrieved file with id: {}", id);
    	
    	return file;
    }
    
    /**
     * Validates whether a file with a same name and parent file id already exists or not.
     *
     * <p>
     * If a file with the input parameter {@code name} and parent file id {@code parentFileId} already exists,
     * then an {@code InvalidInputException} is thrown.
     * </p>
     *
     * @param name Name of a new file input by the user
     * @param parentFileId Folder id of a new file input by the user
     * @throws InvalidInputException If a file with the input parameter {@code name} and parent file id {@code parentFileId} already exists.
     */
    private void validateDuplicateFile(String name, Long parentFileId) throws InvalidInputException {

        log.info("Validating whether an file with name: " + name + " and parent file id:" + parentFileId + " already exists");

        boolean fileExists = fileRepository.existsByNameAndParentFileId(name, parentFileId);

        if (fileExists) {
            String errorMessage = "File with name: " + name + " and parent file id " + parentFileId + " already exists";
            throw new InvalidInputException(ErrorMessageConstants.ERROR_FILE_ALREADY_EXISTS, errorMessage);
        }

        log.info("File with name: " + name + " and parent file id " + parentFileId + " does not exist");
    }
}
