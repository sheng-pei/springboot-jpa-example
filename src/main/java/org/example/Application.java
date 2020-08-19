package org.example;

import org.example.po.SpringBootJpaExamplePO;
import org.example.repository.SpringBootJpaExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class Application {

    private SpringBootJpaExampleRepository repository;

    @Autowired
    public Application(SpringBootJpaExampleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<SpringBootJpaExamplePO> getBySpecification() {
        return this.repository.findAll((root, query, cb) -> {
            Predicate predicate = cb.and(
                    cb.equal(root.<Integer>get("deleted"), 0),
                    cb.equal(root.<Long>get("id"), 0),
                    cb.like(root.get("description"), "test%")
            );
            return query.where(predicate).getRestriction();
        });
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        Application app = context.getBean(Application.class);
        app.getBySpecification();
    }

}
