package com.rio.Idao;

import com.rio.entity.Video;
import java.util.List;

public interface IVideoDao {
    void insert(Video video);
    void update(Video video);
    void delete(String videoId) throws Exception;
    Video findById(String videoId);
    List<Video> findAll();
}
