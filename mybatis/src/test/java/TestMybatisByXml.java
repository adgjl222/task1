import com.mybatis.dao.StudentMapper;
import com.mybatis.service.StudentServiceImpl;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.entity.Student;

import java.util.HashMap;


public class TestMybatisByXml {


        StudentServiceImpl studentService = new StudentServiceImpl();
        /**
         * 添加单条数据
         */
        @Test
        public void testInsert() {

                Student student = new Student();
                student.setLineId(8887);
                student.setQQ(758458439);
                student.setType("java");
                student.setName("测试");
                student.setWill("爱拼才会赢");
                student.setSenior("李诞");
                student.setKnowFrom("知乎");
                student.setGraduate_from("河南工业大学");
                student.setLogURL("http://www.jnshu.com/school/24388/daily?page=1&orderBy=3&sort=1");

                studentService.isnert(student);
        }

        /**
         * 单条数据更新
         */
        @Test
        public void testUpdate() {
                Student student = new Student();
                student.setType("WEB");
                student.setSenior("测试老师");
                student.setLineId(2585);
                studentService.update(student);

        }

        /**
         * 单条数据删除
         */
        @Test
        public void testDelete() {
                studentService.delete(102);
        }

        /**
         * 根据学生姓名、线上学号查询学生信息
         */
        @Test
        public void testSelectOne() {
                HashMap<String, Object> map = new HashMap <String, Object>();
                map.put("name", "刘");
                map.put("lineId", 2585);
                studentService.selectUserByLineIdAndName(map);

        }

        /**
         * 查询全表信息
         */
        @Test
        public void testSelectAll(){
                studentService.selectAll();
        }

}

