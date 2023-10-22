CREATE DATABASE blog;
USE blog;

CREATE TABLE blog(
id int primary key,
blogName varchar(50),
summary varchar(50),
content text,
author varchar(50),
timePost varchar(50)
);


INSERT INTO blog (id,blogName, summary, content, author, timePost) VALUES (
1,
"Dinh dưỡng",
"Chất lượng bữa ăn",
"Dinh dưỡng cũng là yếu tố quan trọng quyết định tới sức khỏe và tuổi thọ. Bữa ăn được xem là cân đối dinh dưỡng và hợp khẩu vị phải có các chất dinh dưỡng hợp lý. Đó là: Khẩu phần bột đường chiếm 65 - 70%, chất đạm chiếm 12 - 14%, chất béo chiếm 18 - 20%. Ngoài ra, còn cần bổ sung thêm chất khoáng, vitamin và nước cho cơ thể (từ rau, trái cây). Đồng thời, cần đảm bảo cân đối về nguồn thức ăn động vật và thực vật. Chất đạm động vật nên chiếm 35 - 40% lượng thức ăn tiêu thụ; chất béo thực vật chiếm 40 - 50% tổng lượng chất béo tiêu thụ.

Mỗi người cũng cần xây dựng cho bản thân một chế độ ăn uống hợp lý, phù hợp với khẩu vị và nguồn thực phẩm sẵn có. Nên phân bổ năng lượng cho các bữa ăn trong ngày như sau: Bữa sáng chiếm 30%; bữa trưa chiếm 40% và bữa tối chiếm 25%, bữa phụ chiếm 5%. Nên phân bổ các chất dinh dưỡng theo tỷ lệ như sau: Chất bột đường chiếm 60%, chất đạm chiếm 15%, chất béo chiếm 25% và chất xơ là 30g/ngày.",
"Nguyễn Văn A",
"2022-1-1"
);