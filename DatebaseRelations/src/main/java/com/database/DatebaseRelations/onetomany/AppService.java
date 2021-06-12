package com.database.DatebaseRelations.onetomany;

import com.database.DatebaseRelations.onetomany.entity.Post;
import com.database.DatebaseRelations.onetomany.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppService {

    @Autowired
    PostRepository postRepository;


    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> finAllPosts() {
        return postRepository.findAll();
    }


    public void deleteAllPosts() {
        postRepository.deleteAll();

    }
}
