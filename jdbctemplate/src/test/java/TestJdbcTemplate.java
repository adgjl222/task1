import com.jdbctemplate.impl.StudentDaoImpl;
import com.jdbctemplate.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.SQLException;
import java.text.ParseException;

public class TestJdbcTemplate {
    //创建Spring实例
    String config = "applicationContext.xml";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
    //获取jdbcTemplate
    StudentDaoImpl studentDao = applicationContext.getBean(StudentDaoImpl.class);

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setLineId(5689);
        student.setName("刘德华");
        student.setQQ(65656565);
        student.setGraduate_from("郑州大学");
        student.setKnowFrom("知乎");
        student.setLogURL("http://www.jnshu.com/school/24388/daily?page=1&orderBy=3&sort=1");
        student.setType("java");
        student.setWill("宣言");
        try {
            studentDao.insertStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectOne(){
        try {
            studentDao.selectUserByLineIdAndName("刘文",2587);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testUpdate(){

        try {
            studentDao.updateStudent("李芳芳",8887);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){

        try {
            studentDao.deleteStudent(102);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        try {
            studentDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

