package com.example.manageruniversity.repository.event;

import com.example.manageruniversity.dto.EventRegisterResponse;
import com.example.manageruniversity.entity.EventRegister;
import com.example.manageruniversity.utils.SystemUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventDAO implements Event {
    private final DataSource dataSource;

    @Override
    public void event(EventRegister eventRegister) throws SQLException {
        Connection connection = dataSource.getConnection();
        open( connection, eventRegister);
        close(connection, eventRegister);
        connection.close();
    }

    private void open(Connection connection, EventRegister eventRegister) throws SQLException {
        String sql = "create event event_open_register_"+ eventRegister.getId() + "\n" +
                "    on schedule AT TIMESTAMP('" + eventRegister.getStart().format(SystemUtils.PATTERN_DATE_ENG) +  "')\n" +
                " do begin \n" +
                "   update major_registers\n" +
                "            set open_register = true\n" +
                "        where major_id in (\n" +
                "            select\n" +
                "                erm.major_id\n" +
                "            from event_registers_major erm\n" +
                "            where erm.event_registers_id = ?\n" +
                "            ) and season_id = ?;\n " +
                "    end;";
        System.out.println(sql);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, eventRegister.getId());
        statement.setLong(2, eventRegister.getSeason().getId());
        statement.execute();
        statement.close();
    }

    private void close(Connection connection, EventRegister eventRegister) throws SQLException {
        String sql = "create event event_close_register_" + eventRegister.getId()+ " \n" +
                "    on schedule AT TIMESTAMP('" + eventRegister.getStart().format(SystemUtils.PATTERN_DATE_ENG) + "') + INTERVAL "+ eventRegister.getIntervalDay() + " DAY \n" +
                "    DO\n" +
                "    BEGIN\n" +
                "        start transaction;\n" +
                "\n" +
                "        DELETE FROM transactions where id is not null ;\n" +
                " update major_registers\n" +
                "            set open_register = false\n" +
                "        where major_id in (\n" +
                "            select\n" +
                "                erm.major_id\n" +
                "            from event_registers_major erm\n" +
                "            where erm.event_registers_id = ?\n" +
                "            ) and season_id =  ?; "  +
                "\n" +
                "   update event_registers\n" +
                "    set expired = true\n" +
                "   where id = ? ;\n" +
                "        UPDATE registers\n" +
                "        set open_transaction = false\n" +
                "        where open_transaction = true;\n" +
                "        commit ;\n" +
                "    end;\n";
        System.out.println(sql);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, eventRegister.getId());
        statement.setLong(2, eventRegister.getSeason().getId());
        statement.setLong(3, eventRegister.getId());
        statement.execute();
        statement.close();
    }


    public List<EventRegisterResponse> findAllEvent() throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "show events";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<EventRegisterResponse> listResponses = new ArrayList<>();
        while (resultSet.next()) {
            EventRegisterResponse response = EventRegisterResponse.builder()
                    .name(resultSet.getString("Name"))
                    .type(resultSet.getString("Type"))
                    .executeAt(resultSet.getDate("Execute at"))
                    .build();
            listResponses.add(response);
        }
        resultSet.close();
        statement.close();
        return listResponses;
    }

}
