package com.naehas.genie.constant.service.file;

import com.naehas.genie.dto.request.file.FileRequestDTO;
import com.naehas.genie.dto.response.file.FileResponseDTO;
import com.naehas.genie.exception.InvalidInputException;

public interface FileService {

    /**
     * Creates and saves a new file in the database.
     *
     * @param fileRequestDto new file request.
     * @return Created file.
     * @throws InvalidInputException <li>
     * If a file with the name and parent file id already exists
     * </li>
     */
    FileResponseDTO createFile(FileRequestDTO fileRequestDto) throws InvalidInputException;

}
