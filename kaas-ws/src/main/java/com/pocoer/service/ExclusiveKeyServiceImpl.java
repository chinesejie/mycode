package com.pocoer.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.pocoer.dao.ExclusiveKeyDAO;
import com.pocoer.manage.ExclusiveKeyManage;
import com.pocoer.manage.KebsiteManage;
import com.pocoer.model.ExclusiveKey;
import com.pocoer.model.Kebsite;

/**
 * ����һ��ExclusiveKeyServiceʵ����
 * �����Ⱪ¶һ�����������û�����
 * @author roadahead
 *
 */
@Component("exclusiveKeyServiceImpl")
@WebService(endpointInterface = "com.pocoer.service.ExclusiveKeyService")
public class ExclusiveKeyServiceImpl implements ExclusiveKeyService{
    private ExclusiveKeyManage exclusiveKeyManage;
    private KebsiteManage kebsiteManage;

    /**
     * ���Ⱪ¶�ķ���������������һ��APIKey��ͬʱ���������ݿ���
     */
    public String getAPIKey(String kebsiteName) {
        Kebsite kebsite =kebsiteManage.getKebsite(kebsiteName);
        if(kebsite==null){
            return "User does not exist!";
        }
        StringBuffer keyString = getAPIKey();
        boolean e = exclusiveKeyManage.isHold(keyString);
        System.out.println(e);
        while(exclusiveKeyManage.isHold(keyString)){
            keyString = getAPIKey();
        }
        exclusiveKeyManage.add(kebsite,keyString);
        return keyString.toString();
    }
    
    /**
     * ����һ��APIKey������
     * @return StringBuffer ��Ҫ���ص�APIKey��StringBuffer
     */
    public StringBuffer getAPIKey(){
        StringBuffer timeString = getTimeString();
        StringBuffer upsetTimeString = getUpsetTimeString(timeString);
        StringBuffer keyString = getKeyString(upsetTimeString);
        return keyString;
    } 
    
    public static void main(String[] args) {
        new ExclusiveKeyServiceImpl().getAPIKey();
    }
    
    /**
     * �����Һõİ���ʱ����Ϣ���ַ�����������Ȼ�󴴽�һ��������ʱ����Ϣ��APIKey
     * @param upsetTimeString ����ʱ����Ϣ���ַ���
     * @return
     */
    private StringBuffer getKeyString(StringBuffer upsetTimeString) {
        Random random = new Random();
        String keyS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#$%^_~-+";
        char[] cKey = keyS.toCharArray();
        StringBuffer KeyString = new StringBuffer();
        for( int i = 0; i < 40; i ++) { 
            if((i==10||i==20||i==30)&&upsetTimeString.length()>0){
                System.out.println(upsetTimeString.substring(0, 13));
                KeyString.append(upsetTimeString.substring(0, 13));
                upsetTimeString.delete(0, 13);
                System.out.println(upsetTimeString.length());
            }
            KeyString.append(cKey[random.nextInt(cKey.length)]);
        }
        System.out.println(KeyString.toString());
        System.out.println("APIKey���ȣ�"+KeyString.length());
        System.out.println("��ѡ�ַ����ȣ�"+keyS.length());
        System.out.println();
        return KeyString;
    }

    /**
     * ����һ����ʱ���ϻ��������39λ�ַ�����
     * @param timeString ��Ҫ��ʱ���ַ�����ϵ�26λ�ַ���
     * @return
     */
    private StringBuffer getUpsetTimeString(StringBuffer timeString) {
        Random random = new Random();
        StringBuffer time = new StringBuffer();
        time.append(new Date().getTime());
        System.out.println(time.toString());
        StringBuffer upset = new StringBuffer();
        String[] str = new String[39];
        for(int i=0;i<13;i++){
            int j = random.nextInt(str.length);
            while(str[j]!=null){
                j = random.nextInt(str.length);
            }
            str[j]="yes";
        }
        for(int i=0;i<str.length;i++){
            if(str[i]==null){
                upset.append(timeString.charAt(0));
                timeString.deleteCharAt(0);
            }else{
                upset.append(time.charAt(0));
                time.deleteCharAt(0);
            }
        }
        System.out.println(upset.toString());
        return upset;
    }

    /**
     * ����һ��26λ����������ַ���
     * ��Ҫ���ص��ַ�����"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%^_~-+"�л�ȡ
     * @return StringBuffer
     */
    public StringBuffer getTimeString(){
        Random random = new Random();
        
        //System.out.println(time.toString());
        String timecharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%^_~-+";
        char[] timechar = timecharacter.toCharArray();
        StringBuffer timeString = new StringBuffer();
        for( int i = 0; i < 26; i ++) { 
            timeString.append(timechar[random.nextInt(timechar.length)]);
        }
        System.out.println(timeString.toString());
        return timeString;
    }

    public ExclusiveKeyManage getExclusiveKeyManage() {
        return exclusiveKeyManage;
    }
    @Resource(name="exclusiveKeyManage")
    public void setExclusiveKeyManage(ExclusiveKeyManage exclusiveKeyManage) {
        this.exclusiveKeyManage = exclusiveKeyManage;
    }

    public KebsiteManage getKebsiteManage() {
        return kebsiteManage;
    }
    @Resource(name="kebsiteManage")
    public void setKebsiteManage(KebsiteManage kebsiteManage) {
        this.kebsiteManage = kebsiteManage;
    }

}
