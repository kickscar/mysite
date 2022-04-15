package me.kickscar.mysite.repository;

import me.kickscar.mysite.vo.GuestbookVo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GuestbookRepositoryTest {
    private static GuestbookVo mockVo;

    @Autowired
    private GuestbookRepository guestbookRepository;

    @BeforeAll
    public static void setup() {
        // Mock
        mockVo = new GuestbookVo();
        mockVo.setName("test");
        mockVo.setPassword("1234");
        mockVo.setMessage("test");
    }

    @Test
    @Order(1)
    public void testInsert()  {
        int count = guestbookRepository.insert(mockVo);
        assertEquals(1, count);
    }

    @Test
    @Order(2)
    public void testFindAll() {
        List<GuestbookVo> result = guestbookRepository.findAll();
        assertTrue(IntStream
                .range(0, result.size())
                .filter(i -> result.get(i).getNo().equals(mockVo.getNo()))
                .findFirst()
                .isPresent());
    }

    @Test
    @Order(3)
    public void testDelete()  {
        int count = guestbookRepository.delete(mockVo);
        assertEquals(1, count);
    }
}