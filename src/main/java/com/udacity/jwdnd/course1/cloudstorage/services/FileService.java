package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }


    public void addFile(MultipartFile fileUpload, int userid) throws IOException {
        try {
            fileMapper.insertFile( new File(null, fileUpload.getOriginalFilename(), fileUpload.getContentType(),
                    Long.toString(fileUpload.getSize()), userid, fileUpload.getBytes() ));

        } catch (IOException e) {
            throw e;
        }
    }


    public List<File> getUploadedFiles(Integer userid){
        return fileMapper.getFiles(userid);
    }

    public boolean isFileAvailable(String filename, Integer userid) {
        File file = fileMapper.getUserFile(userid, filename);

        if(file != null) {
            return false;
        }

        return true;
    }

    public int deleteFile(int fileId) {
        return fileMapper.deleteFile(fileId);
    }

    public File getFileId(Integer fileId){
        return fileMapper.getFileId(fileId);
    }

}