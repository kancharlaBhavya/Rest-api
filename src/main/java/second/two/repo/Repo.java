package second.two.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import second.two.entity.student;

public interface Repo extends JpaRepository<student,Long>{

}
