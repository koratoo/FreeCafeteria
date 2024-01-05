package org.cafeteria.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class freeCafeteriaServiceImpl {
    public static void main(String[] args) {

        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_free_mlsv_api"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=서비스키"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*XML/JSON 여부*/
        urlBuilder.append("&" + URLEncoder.encode("fcltyNm", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시설명*/
        urlBuilder.append("&" + URLEncoder.encode("rdnmadr", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지도로명주소*/
        urlBuilder.append("&" + URLEncoder.encode("lnmadr", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지지번주소*/
        urlBuilder.append("&" + URLEncoder.encode("operInstitutionNm", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*운영기관명*/
        urlBuilder.append("&" + URLEncoder.encode("phoneNumber", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*전화번호*/
        urlBuilder.append("&" + URLEncoder.encode("mlsvPlace", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*급식장소*/
        urlBuilder.append("&" + URLEncoder.encode("mlsvTrget", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*급식대상*/
        urlBuilder.append("&" + URLEncoder.encode("mlsvTime", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*급식시간*/
        urlBuilder.append("&" + URLEncoder.encode("mlsvDate", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*급식요일*/
        urlBuilder.append("&" + URLEncoder.encode("operOpenDate", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*운영시작일자*/
        urlBuilder.append("&" + URLEncoder.encode("operCloseDate", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*운영종료일자*/
        urlBuilder.append("&" + URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*위도*/
        urlBuilder.append("&" + URLEncoder.encode("longitude", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*경도*/
        urlBuilder.append("&" + URLEncoder.encode("referenceDate", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*데이터기준일자*/
        urlBuilder.append("&" + URLEncoder.encode("instt_code", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관코드*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
    }
}
