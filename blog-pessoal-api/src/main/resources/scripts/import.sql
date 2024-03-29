CREATE SCHEMA IF NOT EXISTS articles AUTHORIZATION sa;

CREATE TABLE IF NOT EXISTS articles.Article (
    id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    author VARCHAR(100) NOT NULL,
    publicationDate DATE NOT NULL
);

-- Populando o banco de dados com artigos fictícios sobre TI
INSERT INTO articles.Article (id, title, content, author, publicationDate)
VALUES
    (1,'The Evolution of Cloud Computing', 'Cloud computing has come a long way since its inception. This article explores the evolution of cloud computing and its impact on modern IT infrastructure.', 'John Smith', '2023-01-15'),
    (2,'Artificial Intelligence in Cybersecurity', 'Artificial intelligence (AI) is revolutionizing the field of cybersecurity. Learn how AI-powered solutions are being used to detect and prevent cyber threats.', 'Emily Johnson', '2023-02-20'),
    (3,'Blockchain Technology: Beyond Cryptocurrency', 'Blockchain technology is more than just the backbone of cryptocurrencies like Bitcoin. Discover how blockchain is being used in various industries, from finance to supply chain management.', 'Michael Brown', '2023-03-10'),
    (4,'Machine Learning Applications in Healthcare', 'Machine learning is transforming the healthcare industry. Learn about the applications of machine learning in medical diagnosis, personalized treatment, and predictive analytics.', 'David Wilson', '2023-05-12'),
    (5,'The Rise of DevOps Culture', 'DevOps has become a key practice in modern software development. Explore the principles of DevOps and its impact on IT organizations.', 'Jessica Miller', '2023-04-05'),
    (6,'The Future of Quantum Computing', 'Quantum computing holds the promise of solving complex problems that are beyond the capabilities of classical computers. Discover the potential applications and challenges of quantum computing.', 'Sophia Garcia', '2023-06-18');

