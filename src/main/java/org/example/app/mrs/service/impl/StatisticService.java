package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.mrs.repository.BookRepository;

import java.sql.ResultSet;
import java.util.List;

public class StatisticService {

    BookRepository bookRepository = new BookRepository();
    StatisticsDto statisticsDto = new StatisticsDto();
    ResultSet resultSet = null;
    public StatisticsDto getTotalStatistics() {
        return statisticsDto.mapData(bookRepository.getTotalBooksStatistics());
    }

    public  StatisticsDto getBookStatisticsDto(String isbn){
        return statisticsDto.mapData(bookRepository.getBooksStatisticsByIsbn(isbn));
    }

    public List<StatisticsDto> getAllIsbnStatistics(){
        return statisticsDto.mapDataList(bookRepository.getAllIsbnStatistics());
    }
}
