package io.fl.waterbot.repository;

import io.fl.waterbot.entity.BotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * created by Baxromjon
 * 09.06.2022
 **/
@Repository
public interface BotUserRepository extends JpaRepository<BotUser, UUID> {
    Optional<BotUser> findByChatId(Long chatId);
}
