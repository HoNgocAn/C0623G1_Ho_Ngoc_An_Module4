function addNewBlog() {
    let name = $('#name').val();
    let summary = $('#summary').val();
    let content = $('#content').val();
    let author = $('#author').val();
    let timePost= $('#timePost').val();

    let newBlog = {
        name: name,
        summary: summary,
        content : content,
        author : author,
        timePost : timePost,
    };
    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newBlog),
        //tên API
        url: "http://localhost:8080/api/blog",
        //xử lý khi thành công
        success: console.log("success")
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}


function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/blog",
        //xử lý khi thành công
        success: function (data) {
            // hiển thị danh sách ở đây
            let content = ' <table id="display-list" border="1"><tr>\n' +
                ' <th>Name</td>\n' +
                ' <th>Summary</td>\n' +
                ' <th>Content</td>\n' +
                ' <th>Author</td>\n' +
                ' <th>TimePost</td>\n' +
                ' <th>Delete</td>\n' +
                ' </tr>';
            for (let i = 0; i < data.length; i++) {
                content += `
        <tr>
            <td>${data[i].name}</td>
            <td>${data[i].summary}</td>
            <td>${data[i].content}</td>
            <td>${data[i].author}</td>
            <td>${data[i].timePost}</td>
        </tr>`
            }
            content += "</table>"
            document.getElementById('smartphoneList').innerHTML = content;
        }
    });
}