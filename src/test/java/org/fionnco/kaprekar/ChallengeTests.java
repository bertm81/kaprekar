package org.fionnco.kaprekar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
    
public class ChallengeTests {
      @Test
      public void test1() {
        assertEquals(5, Challenge.kaprekar(1112));
      }
        
        @Test
      public void test2() {
        assertEquals(7, Challenge.kaprekar(456));
      }
        
        @Test
      public void test3() {
        assertEquals(3, Challenge.kaprekar(76));
      }
        
        @Test
      public void test4() {
        assertEquals(5, Challenge.kaprekar(100));
      }
        
        @Test
      public void test5() {
        assertEquals(4, Challenge.kaprekar(101));
      }
}

