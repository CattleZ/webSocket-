<#include "./inc/layout.ftl">
<@layout title="首页">
<#--    不通用-->
    <#include "./inc/header-panel.ftl">
<#--不通用-->
    <div class="layui-container">
        <div class="layui-row layui-col-space15">
            <#include "./inc/left.ftl">
            <#include "./inc/right.ftl">
        </div>
    </div>
</@layout>