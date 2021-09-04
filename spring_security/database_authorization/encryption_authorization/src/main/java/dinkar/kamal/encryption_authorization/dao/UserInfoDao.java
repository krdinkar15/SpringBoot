package dinkar.kamal.encryption_authorization.dao;

import dinkar.kamal.encryption_authorization.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {
        UserInfo findUserByUsername(String username);
}
