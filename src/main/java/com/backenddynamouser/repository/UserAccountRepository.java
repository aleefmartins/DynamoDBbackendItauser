package com.backenddynamouser.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.backenddynamouser.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAccountRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public UserAccount save(UserAccount userAccount){
        dynamoDBMapper.save(userAccount);
        return userAccount;
    }

    public UserAccount getUserAccountById (String userId){
        return dynamoDBMapper.load(UserAccount.class, userId);
    }

    public List <UserAccount> getAllUsers(){
        List <UserAccount> allusers = dynamoDBMapper.scan(UserAccount.class, new DynamoDBScanExpression());
            return allusers;
    }

    public String delete(String userId){
        UserAccount emp = dynamoDBMapper.load(UserAccount.class, userId);
        dynamoDBMapper.delete(emp);
        return "Conta deletada com sucesso!";
    }

    public String update(String userId, UserAccount userAccount){
        dynamoDBMapper.save(userAccount,
                new DynamoDBSaveExpression()
                .withExpectedEntry("userId",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(userId)
                        )));
        return userId;
    }
}
