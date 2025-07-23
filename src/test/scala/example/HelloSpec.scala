package example

class HelloSpec extends munit.FunSuite {
  test("say hello") {
    assertEquals(Hello.greeting, "hello")
  }

  test("say hello with name") {
    assertEquals(Hello.greeting + " Alice", "hello Alice")
  }
}
