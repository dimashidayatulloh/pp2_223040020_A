package main;

import model.MyBatisUtil;
import model.UserMapper;

import org.apache.ibatis.session.SqlSession;
import controller.UserController;
import view.UserView;

public class Main {

    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserView view = new UserView();
        UserController controller = new UserController(view, mapper);

        view.setVisible(true);
    }
}
