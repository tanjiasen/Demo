<template>
  <div>
    <el-container>
      <el-header style="background-color: #5bc0de;height: 130px"></el-header>
      <el-container>
        <el-aside width="200px" style="height: 600px" >

          <el-menu>
<!--            系统管理-->
            <el-submenu index="1">
              <template slot="title"><i class="el-icon-setting"></i>系统管理</template>
              <router-link to="/test01" style="text-decoration: none">
                <el-menu-item>测试一</el-menu-item>
              </router-link>
              <router-link to="/test02" style="text-decoration: none">
                <el-menu-item>测试二</el-menu-item>
              </router-link>

            </el-submenu>
<!--            安全管理-->
            <el-submenu index="2">
              <template slot="title"><i class="el-icon-setting"></i>安全管理</template>
              <el-menu-item>选项1</el-menu-item>
              <el-menu-item>选项2</el-menu-item>
            </el-submenu>
<!--            客户经理-->
            <el-submenu index="3">
              <template slot="title"><i class="el-icon-setting"></i>客户经理</template>
              <el-menu-item>选项1</el-menu-item>
              <el-menu-item>选项2</el-menu-item>
            </el-submenu>
<!--            客户信息-->
            <el-submenu index="4">
              <template slot="title"><i class="el-icon-setting"></i>客户信息</template>
              <router-link to="/components/tjs/CustomerInfo" style="text-decoration: none">
                <el-menu-item>客户信息</el-menu-item>
              </router-link>
              <el-menu-item>选项2</el-menu-item>
            </el-submenu>
<!--            联系人-->
            <el-submenu index="5">
              <template slot="title"><i class="el-icon-setting"></i>联系人</template>
              <el-menu-item>选项1</el-menu-item>
              <el-menu-item>选项2</el-menu-item>
            </el-submenu>
          <!--客户服务-->
          <el-submenu index="6">
              <template slot="title"><i class="el-icon-setting"></i>客户服务</template>
              <el-menu-item>选项1</el-menu-item>
              <el-menu-item>选项2</el-menu-item>
            </el-submenu>
          </el-menu>

        </el-aside>
        <el-container>
          <el-main style="height: 500px">
            <router-view/>
          </el-main>
          <el-footer style="background-color: #2b542c">

          </el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "main",
  crated(){
    sessionStorage.setItem("staff_id","1")
  }
}
</script>

<style scoped>

</style>
