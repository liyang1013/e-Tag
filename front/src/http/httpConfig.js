import axios from 'axios'
import { Message } from 'element-ui'
import store from '@/store'

const http = axios.create({
    timeout: 1000 * 60,
    responseType: 'json'
})

http.interceptors.request.use(
    (request) => {
        request.headers.token = store.getters.getToken
        return request
    }
)

http.interceptors.response.use(
    response => {

        if (response.data?.status && response.data.status === 200) {
            // if (response.data.message !== '成功') Message.info(response.data.message);
        }

        if (response.data?.status && response.data.status === 500) {
            Message.warning(response.data.message);
        }

        return Promise.resolve(response)
    },
    error => {

        Message.error(error);
        return Promise.reject(error)

    }
)

export default http
