import {getAllBooks, addBook} from './bookApi.js'

const init =()=>{
    getAllBooks();//모든 도서목혹 가져오기
    //alert('init')
    const btnAll = document.querySelector("#btnAll");

    btnAll.onclick =()=> {//모두 보기 버튼
        getAllBooks();
    }//btnAll-----

    const getFormData =()=>{
    //사용자가 입력한 값 받기
        //첨부 파일 ==> files 속성을 이용해 추출
        const bookImage = document.querySelector('#bookImage').files[0];
        console.log('bookImage====', bookImage)
        const title = document.querySelector('#title').value;
        const publish = document.querySelector('#author').value;
        const price = document.querySelector('#price').value;
        //유효성 체크
        if(!title || !author){
            alert('모든 값을 입력해야 해요')
            return;
        }
        //파일 업로드시엔 formData를 전송
        let formData = new FormData()
        formData.append("title", title);
        formData.append("author", author);
        if(mbookImage){
            //첨부파일이 있다면
            formData.append('bookImage', bookImage);
        }
        return formData;
    }//getFormData-------

    //파일 업로드 할 때는 ==> FormData객체에 파라미터 데이터를 함께 보내야 한다
    btnCreate.onclick =()=> {//등록 버튼
        let formData = getFormData();
        //api 요청을 보내는 함수 호출
        addBook(formData);//bookApi.js
    }//btnCreate-----

}//init end---------------

document.addEventListener('DOMContentLoaded', init);