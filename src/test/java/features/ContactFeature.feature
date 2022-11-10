Feature: Contact page functionality

  Scenario Outline: Contact form
    Given user on TestPage
    And user goes to Contact page
    When user fill the form as follow
      | firstName | <FirstName> |
      | lastName  | <LastName>  |
      | email     | <Email>     |
      | telephone | <Telephone> |
      | company   | <Company>   |
      | comments  | <Comments>  |

    Then  submit should be <Error Fields>

    Examples:
      | FirstName | LastName | Email         | Telephone         | Company | Comments | Error Fields |
      |           |          |               |                   |         |          | 6            |
      |           |          |               |                   |         | Aaaaaaaa | 5            |
      | A         |          | aa@aa.com     | 111               |         |          | 3            |
      | A         | A        |               | 222               | Bbb     | Cccc     | 1            |
      | A         |          | aa@aa.com     |                   |         |          | 4            |
      | A         | A        | aa@aa.com     |                   | Ddddd   |          | 2            |
      | 1         | Valid    | aa@aa.com     | 55544433          | Valid   | Valid    | 1            |
      | Valid     | 22222    | Valid@a.com   | 55544433          | Valid   | Valid    | 1            |
      | Valid     | Valid    | Valid@a.com   | Bbb               | Valid   | Valid    | 1            |
      | Valid     | Valid    | 1@1           | 55544433          | Valid   | Valid    | 1            |
      | Valid     | Valid    | cccc@amail.com| 11111111222222222 | Valid   | Valid    | 1            |
