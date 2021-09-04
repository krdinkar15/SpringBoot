package dinkar.kamal.encryption_authorization.service;

import dinkar.kamal.encryption_authorization.dao.UserInfoDao;
import dinkar.kamal.encryption_authorization.entity.UserInfo;
import dinkar.kamal.encryption_authorization.entity.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserInfoDao dao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user=dao.findUserByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("This User doesn't exits");
        return new UserInfoDetails(user);
    }
}
