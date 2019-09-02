package top.ridm.maoni;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.ridm.maoni.model.DO.TagDO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@SpringBootApplication
@MapperScan("top.ridm.maoni.DAO.mapper")
public class MaoniApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoniApplication.class, args);
    }

}
