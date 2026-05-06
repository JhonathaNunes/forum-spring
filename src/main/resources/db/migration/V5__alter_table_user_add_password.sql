ALTER TABLE users ADD COLUMN password text;

UPDATE users SET password = '$2a$10$0HMUUvTMTogTUWWWuSXkaOloDPkqjbiPfoRDCORhLD1DKR6ytiEw.' WHERE id = 1;