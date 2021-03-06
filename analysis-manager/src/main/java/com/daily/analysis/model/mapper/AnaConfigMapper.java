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
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    int countByExample(AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    int deleteByExample(AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
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
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    @Insert({
        "insert into ana_config (server_ip, snort_conf_url, ",
        "server_username, server_password, ",
        "server_name, snort_rule_url, ",
        "guarduan_conf_url, alert_url, ",
        "alert_default_line, guardian_log_url, ",
        "snort_start_cmd, snort_stop_cmd, ",
        "snort_log_default_line, guardian_start_cmd, ",
        "guardian_stop_cmd, guardian_log_default_line, ",
        "iptables_url)",
        "values (#{serverIp,jdbcType=VARCHAR}, #{snortConfUrl,jdbcType=VARCHAR}, ",
        "#{serverUsername,jdbcType=VARCHAR}, #{serverPassword,jdbcType=VARCHAR}, ",
        "#{serverName,jdbcType=VARCHAR}, #{snortRuleUrl,jdbcType=VARCHAR}, ",
        "#{guarduanConfUrl,jdbcType=VARCHAR}, #{alertUrl,jdbcType=VARCHAR}, ",
        "#{alertDefaultLine,jdbcType=INTEGER}, #{guardianLogUrl,jdbcType=VARCHAR}, ",
        "#{snortStartCmd,jdbcType=VARCHAR}, #{snortStopCmd,jdbcType=VARCHAR}, ",
        "#{snortLogDefaultLine,jdbcType=INTEGER}, #{guardianStartCmd,jdbcType=VARCHAR}, ",
        "#{guardianStopCmd,jdbcType=VARCHAR}, #{guardianLogDefaultLine,jdbcType=INTEGER}, ",
        "#{iptablesUrl,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="confId", before=false, resultType=Integer.class)
    int insert(AnaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    int insertSelective(AnaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    List<AnaConfig> selectByExample(AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    @Select({
        "select",
        "conf_id, server_ip, snort_conf_url, server_username, server_password, server_name, ",
        "snort_rule_url, guarduan_conf_url, alert_url, alert_default_line, guardian_log_url, ",
        "snort_start_cmd, snort_stop_cmd, snort_log_default_line, guardian_start_cmd, ",
        "guardian_stop_cmd, guardian_log_default_line, iptables_url",
        "from ana_config",
        "where conf_id = #{confId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    AnaConfig selectByPrimaryKey(Integer confId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    int updateByExampleSelective(@Param("record") AnaConfig record, @Param("example") AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    int updateByExample(@Param("record") AnaConfig record, @Param("example") AnaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    int updateByPrimaryKeySelective(AnaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Wed Jun 03 05:29:33 CST 2015
     */
    @Update({
        "update ana_config",
        "set server_ip = #{serverIp,jdbcType=VARCHAR},",
          "snort_conf_url = #{snortConfUrl,jdbcType=VARCHAR},",
          "server_username = #{serverUsername,jdbcType=VARCHAR},",
          "server_password = #{serverPassword,jdbcType=VARCHAR},",
          "server_name = #{serverName,jdbcType=VARCHAR},",
          "snort_rule_url = #{snortRuleUrl,jdbcType=VARCHAR},",
          "guarduan_conf_url = #{guarduanConfUrl,jdbcType=VARCHAR},",
          "alert_url = #{alertUrl,jdbcType=VARCHAR},",
          "alert_default_line = #{alertDefaultLine,jdbcType=INTEGER},",
          "guardian_log_url = #{guardianLogUrl,jdbcType=VARCHAR},",
          "snort_start_cmd = #{snortStartCmd,jdbcType=VARCHAR},",
          "snort_stop_cmd = #{snortStopCmd,jdbcType=VARCHAR},",
          "snort_log_default_line = #{snortLogDefaultLine,jdbcType=INTEGER},",
          "guardian_start_cmd = #{guardianStartCmd,jdbcType=VARCHAR},",
          "guardian_stop_cmd = #{guardianStopCmd,jdbcType=VARCHAR},",
          "guardian_log_default_line = #{guardianLogDefaultLine,jdbcType=INTEGER},",
          "iptables_url = #{iptablesUrl,jdbcType=VARCHAR}",
        "where conf_id = #{confId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AnaConfig record);
}