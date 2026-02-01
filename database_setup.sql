
DROP TABLE IF EXISTS member;

CREATE TABLE member (
                        member_id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        age INT NOT NULL CHECK (age > 0),
                        membership_type VARCHAR(50) NOT NULL,
                        role VARCHAR(30) NOT NULL
                            CHECK (role IN ('Basic Member', 'Student Member', 'Premium Member')),

                        school_name VARCHAR(100),
                        has_trainer BOOLEAN
);


INSERT INTO member (name, age, membership_type, role, school_name, has_trainer)
VALUES
    ('Ali', 20, 'Monthly', 'Student Member', 'AITU', NULL),
    ('Dana', 25, 'Monthly', 'Basic Member', NULL, NULL),
    ('Murat', 35, 'Yearly', 'Premium Member', NULL, TRUE),
    ('Aigerim', 22, 'Monthly', 'Student Member', 'KBTU', NULL),
    ('Nurlan', 40, 'Yearly', 'Premium Member', NULL, FALSE);

SELECT * FROM member;
