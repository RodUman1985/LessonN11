package come.step.dubinin.dao;

import java.util.Optional;

public interface GoodDAO {
    Optional<Good> getByTittle(String tittle);
    Optional<Good> getById(long id);
    List <Good> getAll();
}
