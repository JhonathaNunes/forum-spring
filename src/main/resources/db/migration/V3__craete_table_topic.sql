CREATE TABLE topic
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    title      VARCHAR(255) NOT NULL,
    message    VARCHAR(255) NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime     NOT NULL,
    course_id  BIGINT NULL,
    author_id  BIGINT NULL,
    status     VARCHAR(255) NULL,
    CONSTRAINT pk_topic PRIMARY KEY (id)
);

ALTER TABLE topic
    ADD CONSTRAINT FK_TOPIC_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES users (id);

ALTER TABLE topic
    ADD CONSTRAINT FK_TOPIC_ON_COURSE FOREIGN KEY (course_id) REFERENCES course (id);