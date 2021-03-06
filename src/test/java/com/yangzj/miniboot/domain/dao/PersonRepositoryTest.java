package com.yangzj.miniboot.domain.dao;

import com.yangzj.miniboot.domain.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    private Long id;

    /**
     * 保存person到数据库
     */
    @Before
    public void setUp() {
        assertNotNull(personRepository);
        Person person = new Person("zhangsan", 23);
        Person savedPerson = personRepository.saveAndFlush(person);// 更新 person 对象的姓名
        //savedPerson.setName("UpdatedName");
        //personRepository.save(savedPerson);

        id = savedPerson.getId();
    }

    /**
     * 使用 JPA 自带的方法查找 person
     */
    @Test
    public void should_get_person() {
        Optional<Person> personOptional = personRepository.findById(id);
        assertTrue(personOptional.isPresent());
        assertEquals("zhangsan", personOptional.get().getName());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());

        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        assertEquals(1, personList.size());
        // 清空数据库
        personRepository.deleteAll();
    }

    /**
     * 自定义 query sql 查询语句查找 person
     */

    @Test
    public void should_get_person_use_custom_query() {
        // 查找所有字段
        Optional<Person> personOptional = personRepository.findByNameCustomeQuery("zhangsan");
        assertTrue(personOptional.isPresent());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());
        // 查找部分字段
        String personName = personRepository.findPersonNameById(id);
        assertEquals("zhangsan", personName);
        System.out.println(id);
        // 更新
        personRepository.updatePersonNameById("UpdatedName", id);
        Optional<Person> updatedName = personRepository.findByNameCustomeQuery("UpdatedName");
        assertTrue(updatedName.isPresent());
        // 清空数据库
        personRepository.deleteAll();
    }


    /*//分页选项
    PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.DESC, "age");
    Page<UserDTO> userInformationList = personRepository.getUserInformationList(pageRequest);
    //查询结果总数
    System.out.println(userInformationList.getTotalElements());// 6
    //按照当前分页大小，总页数
    System.out.println(userInformationList.getTotalPages());// 2
    System.out.println(userInformationList.getContent());*/

    /*List<String> personList=new ArrayList<>(Arrays.asList("person1","person2"));
    List<UserDTO> userDTOS = personRepository.filterUserInfo(personList);*/

    /*List<UserDTO> userDTOS = personRepository.filterUserInfoByAge(19,20);*/
}