package bitcamp.myapp.dao.network;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Assignment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDaoImpl implements AssignmentDao {
  
  String dataName;
  DataInputStream in;
  DataOutputStream out;
  Gson gson;

  public AssignmentDaoImpl(String dataName, DataInputStream in, DataOutputStream out) {
    this.dataName = dataName;
    this.in = in;
    this.out = out;
    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  @Override
  public void add(Assignment assignment) {
    try {
      out.writeUTF(dataName);
      out.writeUTF("add");
      out.writeUTF(gson.toJson(assignment));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (!statusCode.equals("200")) {
        throw new Exception(entity);
      }
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      out.writeUTF(dataName);
      out.writeUTF("delete");
      out.writeUTF(gson.toJson(no));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (!statusCode.equals("200")) {
        throw new Exception(entity);
      }

      return gson.fromJson(entity, int.class);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try {
      out.writeUTF(dataName);
      out.writeUTF("findAll");
      out.writeUTF("");

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (!statusCode.equals("200")) {
        throw new Exception(entity);
      }

      return (List<Assignment>) gson.fromJson(entity,
          TypeToken.getParameterized(ArrayList.class, Assignment.class));

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public Assignment findBy(int no) {
    try {
      out.writeUTF(dataName);
      out.writeUTF("findBy");
      out.writeUTF(gson.toJson(no));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (!statusCode.equals("200")) {
        throw new Exception(entity);
      }

      return gson.fromJson(entity, Assignment.class);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int update(Assignment assignment) {
    try {
      out.writeUTF(dataName);
      out.writeUTF("update");
      out.writeUTF(gson.toJson(assignment));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (!statusCode.equals("200")) {
        throw new Exception(entity);
      }

      return gson.fromJson(entity, int.class);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }
}
