<template>
  <div>
    <div style="margin: 10px 0">
      <el-button type="success" plain @click="add" icon="el-icon-plus circle"></el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%"></el-input>
      <el-button @click="load" type="primary" icon="el-icon-search" circle style="margin-left: 5px">
      </el-button>

    </div>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column fixed prop="customerId" label="客户编号" sortable>
      </el-table-column>
      <el-table-column prop="photo" label="照片" type="index" >
      <template slot-scope="scope">
        <el-image
      style="width: 100px; height: 100px"
      :src="scope.row.photo"
      ></el-image>
      </template>
      </el-table-column>
      <el-table-column prop="name" label="姓名">
      </el-table-column>
      <el-table-column prop="sex" label="性别">
      </el-table-column>
      <el-table-column prop="birthdate" label="出生日期">
      </el-table-column>
      <el-table-column prop="telephone" label="电话号码">
      </el-table-column>
      <el-table-column prop="email" label="邮箱地址">
      </el-table-column>
      <el-table-column prop="education" label="学历">
      </el-table-column>
      <el-table-column prop="id_number" label="身份证号码">
      </el-table-column>
      <el-table-column prop="unit" label="客户单位">
      </el-table-column>
      <el-table-column prop="customer_manager" label="客户经理">
      </el-table-column>
      <el-table-column prop="remarks" label="备注">
      </el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" type="success">编辑</el-button>
            <el-button type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--页码-->
    <div class="block">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
        :page-sizes="[5,10,20]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
    <div>
      <el-dialog :title="title" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
        <!-- 需要添加的内容表单 -->
       <el-form v-model="customerInfo" label-width="80px">
          <el-form-item label="照片">
            <el-upload
              class="avatar-uploader"
              name="img"
              action="http://localhost:8080/customerInfo/upload"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img  v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="customerInfo.name"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="customerInfo.sex" label="男" >男</el-radio>
            <el-radio v-model="customerInfo.sex" label="女">女</el-radio>
          </el-form-item>
          <el-form-item label="出生日期">
              <el-date-picker v-model="customerInfo.birthdate" type="date" placeholder="选择日期" :editable="false" :picker-options="pickerOptions" value-format="yyyy-MM-dd">
              </el-date-picker>
          </el-form-item>
          <el-form-item label="联系电话">
            <el-input v-model="customerInfo.telephone"></el-input>
          </el-form-item>
          <el-form-item label="邮箱地址">
            <el-input v-model="customerInfo.email"></el-input>
          </el-form-item>
          <el-form-item label="学历">
             <el-select v-model="customerInfo.education" placeholder="请选择">
                 <el-option
                   v-for="item in options"
                   :key="item.label"
                   :label="item.label"
                   :value="item.label">
                 </el-option>
               </el-select>
          </el-form-item>
          <el-form-item label="身份证号码">
            <el-input v-model="customerInfo.id_number"></el-input>
          </el-form-item>
          <el-form-item label="客户单位">
            <el-input v-model="customerInfo.unit"></el-input>
          </el-form-item>
          <el-form-item label="客户经理">
            <el-input v-model="customerInfo.customer_manager"></el-input>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="customerInfo.remarks"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="handleClose">取 消</el-button>
            <el-button type="primary" @click="save">保存</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request from '@/utils/request'
  export default {
    name: "CustomerInfo",
    components: {

    },
    data() {
      return {
        title:'',
        customerInfo:{
          customerId:'',
          photo:'',
          name:'',
          sex:'',
          birthdate:'',
          telephone:'',
          email:'',
          education:'',
          id_number:'',
          unit:'',
          customer_manager:'',
          remarks:''
        },
        // form: {},
        dialogVisible: false,
        search: '',
        currentPage: 1,
        pageSize: 10,
        total: 0,
        tableData: [],
        imageUrl:'',
        options:[{
          value: '选项1',
                    label: '无'
                  }, {
                    value: '选项2',
                    label: '小学'
                  }, {
                    value: '选项3',
                    label: '初中'
                  }, {
                    value: '选项4',
                    label: '高中'
                  }, {
                    value: '选项5',
                    label: '大专'
                  }, {
                    value: '选项6',
                    label: '本科'
                  }, {
                    value: '选项7',
                    label: '研究生'
                  }, {
                    value: '选项8',
                    label: '博士'
        }],
        value:''
      }
    },
    created() {
      this.load();
    },
    mounted (){
      this.load()
    },
    methods: {
      load() {
        request.get("/customerInfo/selectAll", {
          params: {
            pageNum: this.currentPage,
            pageSize: this.pageSize,
            search: this.search
          }
        }).then(res => {

          this.tableData = res.data
          console.log(this.tableData);
          for(let i =0;i<this.tableData.length;i++){
              this.tableData[i].birthdate = this.formatDate(this.tableData[i].birthdate)

          }
          this.total = res.data.length
        })
      },
      formatDate(oldDate) {
      // 方式1 转换为'yyyy-MM-dd HH:mm:ss'
      function add0(num) { return num < 10 ? '0' + num : num } // 个位数的值在前面补0
      const date = new Date(oldDate)
      const Y = date.getFullYear()
      const M = date.getMonth() + 1
      const D = date.getDate()


      const dateString = Y + '-' + add0(M) + '-' + add0(D)
      return dateString

      // 方式2 转换为'yyyy/MM/dd HH:mm:ss'
      // return new Date(oldDate).toLocaleString()
    },

      add() {
        this.title='添加'

        this.dialogVisible = true
        this.customerInfo = {}
      },
      save() {

        this.dialogVisible = false
        if (this.customerInfo.customerId) {
          this.customerInfo['photo']=this.imageUrl;
          const json = JSON.stringify(this.customerInfo);
          request.post('/customerInfo/updateCus',  JSON.parse(json)).then(res => {
            if (res.code === 200) {
              this.$message({
                type: "success",
                message: "更新成功!"
              })
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
            this.load()
            this.dialogVisible = false
          })

        } else { //新增
          this.customerInfo['photo']=this.imageUrl;
          const json = JSON.stringify(this.customerInfo);
          // console.log(JSON.parse(json));
          request.post("/customerInfo/addCus", JSON.parse(json)).then(res => {
            if (res.code === 200) {
              this.$message({
                type: "success",
                message: "新增成功！"
              })
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
            this.load() //刷新表格数据
            this.dialogVisible = false
          })
        }
        this.load()
      },

      handleEdit(row) {
        // 设置弹窗内独立对象
        this.title='编辑'
        this.customerInfo = JSON.parse(JSON.stringify(row))
        this.dialogVisible = true
      },
      handleClose() {
            this.dialogVisible = false
      },
      handleDelete(row) {
        request.get("/customerInfo/delete/" + row.customerId).then(res => {
          if (res.code === 200) {
            this.$message({
              type: "success",
              message: "删除成功！"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load() //重新加载表格数据
        })
      },
      handleSizeChange(pageSize) {
        this.pageSize = pageSize
        this.load()
      },
      handleCurrentChange(pageNum) {
        this.currentPage = pageNum
        this.load()
      },
      pickerOptions(){
        disableDate: (time) =>{
          return time.getTime()> moment().subtract(1,'days')
        }
      },
      handleAvatarSuccess(res, file) {
          console.log(res);
        this.imageUrl = 'http://localhost:8080'+ res.data

      },
      beforeAvatarUpload(file) {
        const isJPG = file.type == 'image/png'||file.type=='image/jpg'||file.type=='image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 1;
                if (!isJPG) {
                  this.$message.error('上传头像图片只能是 JPG/JPEG/PNG 格式!');
                 }
                if (!isLt2M) {
                  this.$message.error('上传头像图片大小不能超过 1MB!');
                }
                return isJPG && isLt2M;
      }
    }
  }
</script>

<style scoped>
  .avatar-uploader .el-upload {
      border: 1px dashed #d9d9d9;
      border-radius: 6px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
      border-color: #409EFF;
    }
    .avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 178px;
      height: 178px;
      line-height: 178px;
      text-align: center;
    }
    .avatar {
      width: 178px;
      height: 178px;
      display: block;
    }
</style>
