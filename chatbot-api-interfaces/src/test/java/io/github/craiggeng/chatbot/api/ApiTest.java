package io.github.craiggeng.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112154454124/topics?scope=all&count=20");

        get.addHeader("cookie", "UM_distinctid=18741e7bc8d8c8-0b52e1dae1557f-1e525634-1fa400-18741e7bc8ec76; zsxq_access_token=CE1119D5-4518-6985-A765-C7F639A96778_49FFA4E1F931F022; zsxqsessionid=56e0bfac338c6649018e02df084cf0da; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22544858212854124%22%2C%22first_id%22%3A%2218741e0b6c6c4b-0c475b5f965e888-1e525634-2073600-18741e0b6c718e2%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NDFlMGI2YzZjNGItMGM0NzViNWY5NjVlODg4LTFlNTI1NjM0LTIwNzM2MDAtMTg3NDFlMGI2YzcxOGUyIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNTQ0ODU4MjEyODU0MTI0In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22544858212854124%22%7D%2C%22%24device_id%22%3A%2218741e0b6c6c4b-0c475b5f965e888-1e525634-2073600-18741e0b6c718e2%22%7D");
        get.addHeader("Content-Type", "application/json;charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/814282541812552/comments");

        post.addHeader("cookie", "UM_distinctid=18741e7bc8d8c8-0b52e1dae1557f-1e525634-1fa400-18741e7bc8ec76; zsxq_access_token=CE1119D5-4518-6985-A765-C7F639A96778_49FFA4E1F931F022; zsxqsessionid=56e0bfac338c6649018e02df084cf0da; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22544858212854124%22%2C%22first_id%22%3A%2218741e0b6c6c4b-0c475b5f965e888-1e525634-2073600-18741e0b6c718e2%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NDFlMGI2YzZjNGItMGM0NzViNWY5NjVlODg4LTFlNTI1NjM0LTIwNzM2MDAtMTg3NDFlMGI2YzcxOGUyIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNTQ0ODU4MjEyODU0MTI0In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22544858212854124%22%7D%2C%22%24device_id%22%3A%2218741e0b6c6c4b-0c475b5f965e888-1e525634-2073600-18741e0b6c718e2%22%7D");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"嘎巴菜\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
