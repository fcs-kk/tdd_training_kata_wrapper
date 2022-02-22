package jp.co.fcskk;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    WrapperTest.DegenerateTests.class,
    WrapperTest.wrapWordsTest.class
})

public class WrapperTest {

  /*
   * 異常系テスト
   */
  public static class DegenerateTests {
      @Test
      public void emptyString() throws Exception {
          assertThat(Wrapper.wrap("", 1), equalTo(""));
      }

      @Test
      public void stringShorterThanCol() throws Exception {
        assertThat(Wrapper.wrap("this", 10), equalTo("this"));
      }
  }

  /*
   * 正常系テスト
   */
  public static class wrapWordsTest {
      @Test
      public void wrapTwoWordsAfterSpace() throws Exception {
        assertThat(Wrapper.wrap("word word", 6), equalTo("word\nword"));
      }
  
      @Test
      public void wrapThreeWordsAfterFirstSpace() throws Exception {
        assertThat(Wrapper.wrap("word word word", 6), equalTo("word\nword\nword"));  
      }

      @Test
      public void wrapOnWordBoundary() throws Exception {
        assertThat(Wrapper.wrap("word word", 5), equalTo("word\nword"));      
      }

      @Test
      public void wrapWellBeforeWordBoundary() throws Exception {
        assertThat(Wrapper.wrap("word word", 3), equalTo("wor\nd\nwor\nd"));
      }

      @Test
      public void wrapJustBeforeWordBoundary() throws Exception {
        assertThat(Wrapper.wrap("word word", 4), equalTo("word\nword"));
      }

      @Test
      public void wrapJustAfterSpace() throws Exception {
        assertThat(Wrapper.wrap("word word ", 5), equalTo("word\nword"));
      }

      @Test
      public void wrapThreeWordsAfterSecondSpace() throws Exception {
        assertThat(Wrapper.wrap("word word word", 9), equalTo("word word\nword"));
      }
    }
}
