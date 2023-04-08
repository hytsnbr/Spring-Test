-- CREATE 
-- DATABASE test;

CREATE TABLE todo_data
(
    id        serial,
    process   int  not null,
    text      text not null,
    create_at timestamp default CURRENT_TIMESTAMP,
    update_at timestamp
);