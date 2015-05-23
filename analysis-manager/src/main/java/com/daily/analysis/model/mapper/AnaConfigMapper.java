package com.daily.analysis.model.mapper;

import com.daily.analysis.model.pojo.AnaConfig;
import com.daily.analysis.model.pojo.AnaConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface AnaConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    int countByExample(AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    int deleteByExample(AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    @Delete({
        "delete from ana_config",
        "where conf_id = #{confId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer confId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    @Insert({
        "insert into ana_config (server_ip, snort_conf_url, ",
        "server_username, server_password, ",
        "server_name)",
        "values (#{serverIp,jdbcType=VARCHAR}, #{snortConfUrl,jdbcType=VARCHAR}, ",
        "#{serverUsername,jdbcType=VARCHAR}, #{serverPassword,jdbcType=VARCHAR}, ",
        "#{serverName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="confId", before=false, resultType=Integer.class)
    int insert(AnaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    int insertSelective(AnaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    List<AnaConfig> selectByExample(AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    @Select({
        "select",
        "conf_id, server_ip, snort_conf_url, server_username, server_password, server_name",
        "from ana_config",
        "where conf_id = #{confId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    AnaConfig selectByPrimaryKey(Integer confId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    int updateByExampleSelective(@Param("record") AnaConfig record, @Param("example") AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    int updateByExample(@Param("record") AnaConfig record, @Param("example") AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    int updateByPrimaryKeySelective(AnaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    @Update({
        "update ana_config",
        "set server_ip = #{serverIp,jdbcType=VARCHAR},",
          "snort_conf_url = #{snortConfUrl,jdbcType=VARCHAR},",
          "server_username = #{serverUsername,jdbcType=VARCHAR},",
          "server_password = #{serverPassword,jdbcType=VARCHAR},",
          "server_name = #{serverName,jdbcType=VARCHAR}",
        "where conf_id = #{confId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AnaConfig record);
}