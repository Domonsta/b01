async function get1(bno) {

    const result = await axios.get(`/replies/list/${bno}`)

    // console.log(result.data)

    return result;
}

async function getList({bno, page, size, goLast}){

    const result = await axios.get(`/replies/list/${bno}`, {params: {page, size}})

    if(goLast){
        const total = result.data.total
        const lastPage = parseInt(Math.ceil(total/size))

        return getList({bno:bno, page:lastPage, size:size})
    }

    return result.data

}

async function addReply(replyObj) {
    const response = await axios.post(`/replies/`, replyObj) //컨텍스트 루프 오타 주의!
    return response.data
}

//조회, 수정, json 데이터 처리 통신 코드 추가

async function getReply(rno) {
    const response = await axios.get(`/replies/${rno}`)
    return response.data
}

async function modifyReply(replyObj){

    const response = await axios.put(`/replies/${replyObj.rno}`, replyObj)
    return response.data

}

//댓글 삭제 함수
async function removeReply(rno){
    const response = await axios.delete(`/replies/${rno}`)
    return response.data
}