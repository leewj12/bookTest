const baseUrl = '/book1'

//파일 업로드
const addBook = async(formData)=>{
    try{
        const response = await fetch(baseUrl, {
            method: 'post',
            body: formData
        })

        const data = await response.json();
        if(data.status == "success"){
            getAllBooks();
        } else{
            alert(data.message);
        }
    } catch(error){
        alert('Error: ', error);
        console.error(error);
    }
}//------------------------------------------

//전체책 조회
const getAllBooks= async ()=>{
    try{
        const response = await fetch(baseUrl);
        const data = await response.json();
        renderBooks(data);
    } catch(error){
        alert('Error: ' + error);
    }
}//-------------------------------------------

const renderBooks =(data)=> {
    const result = document.querySelector('#result');//==>tbody 태그
    let str = '';
    //배열.forEach(콜백함수)
    data.forEach((book)=>{
        str += `<tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.id}</td>
                    <td>
                        <button class = 'btn btn-warning'
                        onclick = 'getBook("${book.id}")'>수정</button>
                        <button class = 'btn btn-secondary'
                        onclick = 'goRemove("${book.id}")'>삭제</button>
                    </td>
                </tr>`
    })//forEach--------------------
    result.innerHTML = str;
};//renderBooks---------

export {getAllBooks, addBook};