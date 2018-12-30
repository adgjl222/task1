import com.jdbc.dao.JdbcDao;
import com.jdbc.entity.Student;
import com.jdbc.impl.JdbcImplements;
import org.junit.Test;

public class JdbcTest {

    JdbcDao dao = new JdbcImplements();
    /**
     *添加单条数据
     */
    @Test
    public void testInsert() {

        Student student = new Student();
            student.setLineId(3896);
            student.setName("王唯一");
            student.setQQ(256886688);
            student.setWill("爱拼才会赢");
            student.setSenior("林山");
            student.setType("web");
            student.setKnowFrom("知乎");
            student.setLogURL("http://www.jnshu.com/school/24388/daily?page=1&orderBy=3&sort=1");
            student.setEstimatedTtime((long) 445454);
            student.setGraduate_from("郑州大学");
            student.setCreatedAt((long)44444);
            student.setUpdatedAt((long)545668);
            dao.insert(student);
        }

    /**
     *更新单条数据
     */
    @Test
    public void testUpdate(){
            dao.update(2587,"刘");

        }

    /**
     * 删除单条数据
     */
    @Test
        public void testDelete(){
            dao.delete(7);
        }

    /**
     * 查询全表
     */
    @Test
        public void testSelectAll(){
            dao.selectAll();
        }

    /**
     * 根据线上学号和姓名查询报名信息
     */
    @Test
        public void testSelectOne(){
            dao.selectUserByLineIdAndName(4,"刘");
        }




}
