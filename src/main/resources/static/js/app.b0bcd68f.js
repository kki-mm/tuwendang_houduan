(function(){var e={1067:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return c}});var i=function(){var e=this,t=e._self._c;return t("div",[e._v(" 这是归档区document ")])},r=[],a={data(){return{}}},n=a,l=o(1001),s=(0,l.Z)(n,i,r,!1,null,null,null),c=s.exports},2959:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return u}});var i=function(){var e=this,t=e._self._c;return t("el-form",{ref:"form",staticClass:"login-container",attrs:{model:e.form,rules:e.rules}},[t("h3",{staticClass:"login_title",staticStyle:{"text-align":"center"}},[e._v("徐州燃控院系统登录")]),t("el-form-item",{attrs:{label:"用户名",prop:"username"}},[t("el-input",{attrs:{plaseholder:"请输入用户名"},model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),t("el-form-item",{attrs:{label:"密码",prop:"password"}},[t("el-input",{attrs:{type:"password",plaseholder:"请输入密码"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),t("el-form-item",[t("el-button",{staticStyle:{"margin-left":"140px"},attrs:{type:"primary"},on:{click:e.submit}},[e._v("登录")])],1)],1)},r=[],a=(o(7658),o(680)),n={data(){return{loginFlag:0,data:{},menu:[],form:{username:"",password:""},rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]}}},methods:{submit(){this.$http({method:"post",url:"/login",data:this.form}).then((e=>{console.log("start to login"),this.data=e.data,console.log(e),this.$refs.form.validate((e=>{e&&(console.log("start to jump to workhome"),1===this.data.code?(console.log("get token"+this.data.data),a.Z.set("token",this.data.data),console.log("cookie:token"),console.log(a.Z.get("token")),this.menu=[{path:"/workhome",name:"workhome",label:"工作区",icon:"s-claim",url:"workhome.vue"},{path:"/publish",name:"publish",label:"发布区",icon:"s-promotion",url:"publish.vue"},{path:"/document",name:"document",label:"归档区",icon:"s-management",url:"document.vue"},{path:"/userinfo",name:"userinfo",label:"个人信息管理",icon:"s-custom",url:"userinfo.vue"}],console.log("用户登录成功！")):alert("账号或密码错误！"),this.$store.commit("setmenu",this.menu),this.$store.commit("addmenu",this.$router),this.$router.push("/workhome"))}))}))}},created(){}},l=n,s=o(1001),c=(0,s.Z)(l,i,r,!1,null,null,null),u=c.exports},2163:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return w}});var i=function(){var e=this,t=e._self._c;return t("div",[t("el-container",[t("el-aside",{attrs:{width:"auto"}},[t("CommonAside")],1),t("el-container",[t("el-header",[t("CommonHeader")],1),t("el-main",[t("router-view")],1)],1)],1)],1)},r=[],a=function(){var e=this,t=e._self._c;return t("div",{staticClass:"header-content"},[t("div",{staticClass:"left-content"}),t("div",{staticClass:"right-content"},[t("el-dropdown",{on:{command:e.handleclick}},[t("span",{staticClass:"el-dropdown-link"},[t("img",{attrs:{src:o(2315),alt:""}})]),t("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[t("el-dropdown-item",[e._v("个人中心")]),t("el-dropdown-item",{attrs:{command:"cancel"}},[e._v("退出")])],1)],1)],1)])},n=[],l=(o(7658),o(680)),s={data(){return{}},methods:{handlemenu(){this.$store.commit("collapseMenu")},handleclick(e){"cancel"===e&&(l.Z.remove("token"),this.$router.push("/login"))}}},c=s,u=o(1001),d=(0,u.Z)(c,a,n,!1,null,"6a4d1964",null),m=d.exports,p=function(){var e=this,t=e._self._c;return t("el-menu",{staticClass:"el-menu-vertical-demo",attrs:{"default-active":"1-4-1",collapse:!1,"background-color":"#545c64","text-color":"#fff","active-text-color":"#ffd04b"},on:{open:e.handleOpen,close:e.handleClose}},[t("h3",[e._v(e._s("徐州燃控院后台管理"))]),e._l(e.haschildren,(function(o){return t("el-submenu",{key:o.label,attrs:{index:o.label}},[t("template",{slot:"title"},[t("i",{class:`el-icon-${o.icon}`}),t("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(o.label))])]),e._l(o.children,(function(o){return t("el-menu-item-group",{key:o.path},[t("el-menu-item",{attrs:{index:o.path},on:{click:function(t){return e.clickMenu(o)}}},[e._v(e._s(o.label))])],1)}))],2)})),e._l(e.nochildren,(function(o){return t("el-menu-item",{key:o.name,attrs:{index:o.name},on:{click:function(t){return e.clickMenu(o)}}},[t("i",{class:`el-icon-${o.icon}`}),t("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(o.label))])])}))],2)},f=[],h={data(){return{}},methods:{handleOpen(e,t){console.log(e,t)},handleClose(e,t){console.log(e,t)},clickMenu(e){this.$route.path===e.path||"/home"===this.$route.path&&"/"===e.path||this.$router.push(e.path)}},computed:{nochildren(){return this.menudata.filter((e=>!e.children))},haschildren(){return this.menudata.filter((e=>e.children))},menudata(){return JSON.parse(l.Z.get("menu"))||this.$store.state.tab.menu}}},b=h,_=(0,u.Z)(b,p,f,!1,null,"61a4adb4",null),v=_.exports,g={data(){return{}},components:{CommonAside:v,CommonHeader:m}},k=g,y=(0,u.Z)(k,i,r,!1,null,"4af4a234",null),w=y.exports},1669:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return c}});var i=function(){var e=this,t=e._self._c;return t("div",[e._v(" 这是发布区publish ")])},r=[],a={data(){return{}}},n=a,l=o(1001),s=(0,l.Z)(n,i,r,!1,null,null,null),c=s.exports},7264:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return c}});var i=function(){var e=this,t=e._self._c;return t("div",[t("el-button",{attrs:{type:"primary"},on:{click:e.handleAdd}},[e._v("+新建")]),t("el-table",{staticStyle:{width:"100%"},attrs:{stripe:"",height:"90%",data:e.tabledata}},[t("el-table-column",{attrs:{prop:"name",label:"项目名称",width:"180"}}),t("el-table-column",{attrs:{prop:"number",label:"项目令号",width:"180"}}),t("el-table-column",{attrs:{prop:"department",label:"项目科室",width:"180"}}),t("el-table-column",{attrs:{label:"建档时间","value-format":"yyyy-MM-DD"}}),t("el-table-column",{attrs:{label:"操作"}}),t("el-tabel-column",{scopedSlots:e._u([{key:"default",fn:function(o){return[t("el-button",{attrs:{size:"mini"},on:{click:function(t){return e.handleEdit(o.row)}}},[e._v("编辑")]),t("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(t){return e.handleDelete(o.row)}}},[e._v("删除")])]}}])})],1)],1)},r=[],a={data(){return{tabeldata:[]}},methods:{}},n=a,l=o(1001),s=(0,l.Z)(n,i,r,!1,null,null,null),c=s.exports},190:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return c}});var i=function(){var e=this,t=e._self._c;return t("el-row",[t("el-col",{attrs:{span:8}},[t("el-card",[t("div",{staticClass:"user"},[t("el-upload",{staticClass:"upload",attrs:{action:"https://jsonplaceholder.typicode.com/posts/","show-file-list":!1}},[e.imageUrl?t("img",{staticClass:"avatar",attrs:{src:e.imageUrl}}):t("i",{staticClass:"el-icon-plus avatar-uploader-icon"})]),t("div",{staticClass:"user-info"},[t("p",{staticClass:"name"},[e._v("Admin")]),t("p",{staticClass:"access"},[e._v("13012340000")])]),t("div",{staticStyle:{width:"120px",height:"30px","margin-bottom":"-170px","margin-right":"-34px"}},[e._v(" 修改账号 ")])],1),t("div",{staticClass:"account-info"},[t("p",{},[e._v("职 务：")]),t("p",{},[e._v("所属部门：")]),t("p",{},[e._v("所属科室：")])])])],1),t("el-col",{staticStyle:{"padding-left":"40px"},attrs:{span:15}},[t("el-card",{staticStyle:{"margin-top":"20px",height:"auto"}},[t("p",[e._v("参与项目：")]),t("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData}},e._l(e.tableLabel,(function(e,o){return t("el-table-column",{attrs:{prop:o,label:e}})})),1)],1)],1)],1)},r=[],a={data(){return{imageUrl:"",tableData:[{name:"项目一",introduce:"项目简介.....",member:"人员一、人员二",url:"跳转"}],tableLabel:{name:"项目名称",introduce:"项目简介",member:"参与人员",url:"跳转"}}},methods:{handleAvatarSuccess(e,t){this.imageUrl=URL.createObjectURL(t.raw)},beforeAvatarUpload(e){const t="image/jpeg"===e.type,o=e.size/1024/1024<2;return t||this.$message.error("上传头像图片只能是 JPG 格式!"),o||this.$message.error("上传头像图片大小不能超过 2MB!"),t&&o}}},n=a,l=o(1001),s=(0,l.Z)(n,i,r,!1,null,null,null),c=s.exports},8609:function(e,t,o){"use strict";o.r(t),o.d(t,{default:function(){return W}});var i=function(){var e=this,t=e._self._c;return t("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[t("el-dialog",{attrs:{title:"",visible:e.dialogVisible,width:"70%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[t("ModifyProject",{key:e.timer,attrs:{thisRow:e.thisRow}}),t("span",{attrs:{slot:"footer"},slot:"footer"})],1),t("el-dialog",{attrs:{title:"",visible:e.dialogVisible_1,width:"70%"},on:{"update:visible":function(t){e.dialogVisible_1=t}}},[t("ViewProject",{key:e.timer,attrs:{tabledata:e.thisRow}})],1),t("el-dialog",{attrs:{title:"",visible:e.dialogVisible_2,width:"80%"},on:{"update:visible":function(t){e.dialogVisible_2=t}}},[t("uploadDocument",{key:e.timer,attrs:{tabledata:e.thisRow}})],1),t("el-tab-pane",{staticClass:"manage",attrs:{label:"技术部",name:"first"}},[t("div",{staticClass:"manage-header"},[t("el-button",{attrs:{type:"primary"},on:{click:e.handleAdd}},[e._v(" +新建 ")]),t("el-form",{attrs:{inline:!0,model:e.userform}},[t("el-form-item",[t("el-select",{attrs:{multiple:"",filterable:"",remote:"","reserve-keyword":"",placeholder:"请输入关键词","remote-method":e.remoteMethod,loading:e.loading},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}},e._l(e.options,(function(e){return t("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1),t("el-button",{attrs:{type:"primary"}},[e._v("查询")])],1)],1)],1),t("div",{staticClass:"common-tabel"},e._l(e.tabledata,(function(o,i){return t("el-table",{staticStyle:{width:"100%",height:"auto"},attrs:{stripe:"",height:"90%",data:o}},[t("el-table-column",{attrs:{prop:"project_name",label:"项目名称",width:"180"}}),t("el-table-column",{attrs:{prop:"project_id",label:"项目令号",width:"180"}}),t("el-table-column",{attrs:{prop:"project_create",label:"项目创建人",width:"180"}}),t("el-table-column",{scopedSlots:e._u([{key:"default",fn:function(o){return[t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.projectInfo(o.row)}}},[e._v("详情")]),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.handleEdit(o.row)}}},[e._v("编辑")]),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.handlePulish(o.row)}}},[e._v("发布")]),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.handleFile(o.row)}}},[e._v("归档")]),t("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(t){return e.handleDelete(o.row)}}},[e._v("删除")]),t("el-button",{attrs:{type:"info",size:"mini"},on:{click:function(t){return e.uploadDocument(o.row)}}},[e._v("技术资料")])]}}],null,!0)})],1)})),1)]),t("el-tab-pane",{attrs:{label:"项目管理部",name:"second"}})],1)},r=[],a=(o(541),o(680)),n=o(4161),l=o(4471);const s=e=>l.Z.post("user/del",e);var c,u,d=function(){var e=this,t=e._self._c;return t("div",[t("el-descriptions",{attrs:{column:1,border:""}},e._l(e.thisProject,(function(o,i,r){return t("el-descriptions-item",{attrs:{label:e.label[r],contentStyle:{"text-align":"center"}}},[e._v(" "+e._s(o)+" ")])})),1)],1)},m=[],p={props:["tabledata"],name:"MyUser",data(){return{thisProject:this.tabledata,label:["项目名称","项目令号","项目创建者","项目创建时间","项目结束时间","项目成员","项目审批人","是否审批成功","资料类型","合同交期","销售经理","合同金额","设计经理","服务人员","发货方式","订货单位","收货单位","收货地址","到站","邮编","联系人","联系人电话","传真","发货单位","发货条件","电仪时间节点","设备时间节点"]}}},f=p,h=o(1001),b=(0,h.Z)(f,d,m,!1,null,null,null),_=b.exports,v=function(){var e=this,t=e._self._c;return t("el-form",{ref:"form",attrs:{model:e.form,inline:!0,rules:e.rules}},[t("el-divider",{attrs:{"content-position":"left"}},[e._v("合同信息")]),t("el-form-item",{attrs:{label:"项目名称",prop:"project_name"}},[t("el-input",{model:{value:e.form.project_name,callback:function(t){e.$set(e.form,"project_name",t)},expression:"form.project_name"}})],1),t("el-form-item",{attrs:{label:"项目令号",prop:"project_id"}},[t("el-input",{model:{value:e.form.project_id,callback:function(t){e.$set(e.form,"project_id",t)},expression:"form.project_id"}})],1),t("el-form-item",{attrs:{label:"合同交期",prop:"contract_date"}},[t("el-col",{attrs:{span:11}},[t("el-form-item",[t("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.form.contract_date,callback:function(t){e.$set(e.form,"contract_date",t)},expression:"form.contract_date"}})],1)],1)],1),t("el-form-item",{attrs:{label:"销售经理",prop:"sale_manager"}},[t("el-input",{model:{value:e.form.sale_manager,callback:function(t){e.$set(e.form,"sale_manager",t)},expression:"form.sale_manager"}})],1),t("el-form-item",{attrs:{label:"合同金额",prop:"contract_money"}},[t("el-input",{model:{value:e.form.contract_money,callback:function(t){e.$set(e.form,"contract_money",e._n(t))},expression:"form.contract_money"}})],1),t("el-divider",{attrs:{"content-position":"left"}},[e._v("设计信息")]),t("el-form-item",{attrs:{label:"电仪设计节点",prop:"time_dy"}},[t("el-input",{model:{value:e.form.time_dy,callback:function(t){e.$set(e.form,"time_dy",t)},expression:"form.time_dy"}})],1),t("el-form-item",{attrs:{label:"设备设计节点",prop:"time_sb"}},[t("el-input",{model:{value:e.form.time_sb,callback:function(t){e.$set(e.form,"time_sb",t)},expression:"form.time_sb"}})],1),t("el-form-item",{attrs:{label:"设计经理",prop:"design_manager"}},[t("el-input",{model:{value:e.form.design_manager,callback:function(t){e.$set(e.form,"design_manager",t)},expression:"form.design_manager"}})],1),t("el-form-item",{attrs:{label:"服务人员"}},[t("el-input",{model:{value:e.form.serve_person,callback:function(t){e.$set(e.form,"serve_person",t)},expression:"form.serve_person"}})],1),t("el-divider",{attrs:{"content-position":"left"}},[e._v("物流信息")]),t("el-form-item",{attrs:{label:"发货方式",prop:"deliver_way"}},[t("el-input",{model:{value:e.form.deliver_way,callback:function(t){e.$set(e.form,"deliver_way",t)},expression:"form.deliver_way"}})],1),t("el-form-item",{attrs:{label:"订货单位",prop:"order_unit"}},[t("el-input",{model:{value:e.form.order_unit,callback:function(t){e.$set(e.form,"order_unit",t)},expression:"form.order_unit"}})],1),t("el-form-item",{attrs:{label:"收货单位",prop:"receive_unit"}},[t("el-input",{model:{value:e.form.receive_unit,callback:function(t){e.$set(e.form,"receive_unit",t)},expression:"form.receive_unit"}})],1),t("el-form-item",{attrs:{label:"收货地址",prop:"receive_address"}},[t("el-input",{model:{value:e.form.receive_address,callback:function(t){e.$set(e.form,"receive_address",t)},expression:"form.receive_address"}})],1),t("el-form-item",{attrs:{label:"到站",prop:"arrive_station"}},[t("el-input",{model:{value:e.form.arrive_station,callback:function(t){e.$set(e.form,"arrive_station",t)},expression:"form.arrive_station"}})],1),t("el-form-item",{attrs:{label:"邮编",prop:"mail"}},[t("el-input",{model:{value:e.form.mail,callback:function(t){e.$set(e.form,"mail",t)},expression:"form.mail"}})],1),t("el-form-item",{attrs:{label:"联系人",prop:"contact_people"}},[t("el-input",{model:{value:e.form.contact_people,callback:function(t){e.$set(e.form,"contact_people",t)},expression:"form.contact_people"}})],1),t("el-form-item",{attrs:{label:"联系方式",prop:"contact_people_phone"}},[t("el-input",{model:{value:e.form.contact_people_phone,callback:function(t){e.$set(e.form,"contact_people_phone",t)},expression:"form.contact_people_phone"}})],1),t("el-form-item",{attrs:{label:"传真",prop:"fax"}},[t("el-input",{model:{value:e.form.fax,callback:function(t){e.$set(e.form,"fax",t)},expression:"form.fax"}})],1),t("el-form-item",{attrs:{label:"发货单位",prop:"send_unit"}},[t("el-input",{model:{value:e.form.send_unit,callback:function(t){e.$set(e.form,"send_unit",t)},expression:"form.send_unit"}})],1),t("el-form-item",{attrs:{label:"发货条件",prop:"send_condition"}},[t("el-input",{model:{value:e.form.send_condition,callback:function(t){e.$set(e.form,"send_condition",t)},expression:"form.send_condition"}})],1),t("el-divider",{attrs:{"content-position":"left"}},[e._v("请选择部门")]),t("el-form-item",[e.department[0]?t("pick",{attrs:{Options:e.department}}):e._e()],1),t("el-divider",{attrs:{"content-position":"left"}},[e._v("请选择科室")]),t("div",[e.room[0]?t("pick",{attrs:{Options:e.room}}):e._e()],1),t("div",{staticClass:"leader"},[t("el-divider",{attrs:{"content-position":"left"}},[e._v("请选择审批人")]),t("div",[t("pick",{attrs:{Options:[1,1]}})],1)],1),t("div",{staticClass:"member"},[t("el-divider",{attrs:{"content-position":"left"}},[e._v("请选择项目成员")]),t("div",[t("pick",{attrs:{Options:[1,1]}})],1)],1),t("div",{staticClass:"fileType"},[t("el-divider",{attrs:{"content-position":"left"}},[e._v("请选择技术资料类型上传列表")]),t("div",[t("pick",{attrs:{Options:[1,1]}})],1)],1),t("el-form-item",[t("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("form")}}},[e._v("立即创建")]),t("el-button",{on:{click:function(t){return e.resetForm("form")}}},[e._v("重置")])],1)],1)},g=[],k=function(){var e=this,t=e._self._c;return t("div",[t("el-checkbox",{attrs:{indeterminate:e.isIndeterminate},on:{change:e.handleCheckAllChange},model:{value:e.checkAll,callback:function(t){e.checkAll=t},expression:"checkAll"}},[e._v("全选")]),t("div",{staticStyle:{margin:"15px 0"}}),t("el-checkbox-group",{on:{change:e.handleCheckedCitiesChange},model:{value:e.checkedCities,callback:function(t){e.checkedCities=t},expression:"checkedCities"}},e._l(e.cities,(function(o){return t("el-checkbox",{key:o.id,attrs:{label:o}},[e._v(e._s(o))])})),1)],1)},y=[],w={props:["Options"],data(){return{checkAll:!1,checkedCities:["上海","北京"],cities:this.Options,isIndeterminate:!0}},methods:{handleCheckAllChange(e){this.checkedCities=e?this.Options:[],this.isIndeterminate=!1},handleCheckedCitiesChange(e){let t=e.length;this.checkAll=t===this.cities.length,this.isIndeterminate=t>0&&t<this.cities.length}}},x=w,$=(0,h.Z)(x,k,y,!1,null,null,null),C=$.exports,j={components:{pick:C},props:["thisRow"],data(){return{department:[],room:[],form:this.thisRow,rules:{project_name:[{required:!0,message:"项目名称不能为空",trigger:"blur"}],project_id:[{required:!0,message:"项目令号不能为空",trigger:"blur"},{pattern:/^[^\u4e00-\u9fa5]+$/,message:"不允许输入中文",trigger:"change"},{pattern:/^[A-Za-z0-9\u4e00-\u9fa5]+$/,message:"不允许输入空格等特殊符号",trigger:"change"}],time_dy:[{required:!0,message:"电仪节点不能为空",trigger:"blur"}],time_sb:[{required:!0,message:"设备节点不能为空",trigger:"blur"}],sale_manager:[{pattern:/^([\\u4e00-\\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$/,message:"请输入正确的名字",trigger:"change"}],contract_money:[{type:"number",message:"请输入数字",trigger:"change"}],mail:[{pattern:/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,min:9,max:18,message:"邮箱格式错误",trigger:"change"}],contact_people_phone:[{pattern:/^1[3-9]\d{9}$/,min:11,max:11,message:"手机号格式错误",trigger:"blur"}]}}},methods:{async getData(){const{data:e}=await this.$http.get("http://yapi.smart-xwork.cn/mock/226692/project/department");this.department=e;const{data:t}=await this.$http.get("http://yapi.smart-xwork.cn/mock/226692/postProject/room");this.room=t},submitForm(e){this.$refs[e].validate((e=>{if(!e)return console.log("error submit!!"),!1;alert("submit!")})),this.$http({method:"post",url:"http://yapi.smart-xwork.cn/mock/226692/postProject/work",data:this.form,headers:{"Content-Type":"\tapplication/x-www-form-urlencoded"}})},resetForm(e){this.$refs[e].resetFields(),this.form={}}},created(){this.getData()}},O=j,Z=(0,h.Z)(O,v,g,!1,null,"3c29db8c",null),S=Z.exports,V=function(){var e=this,t=e._self._c;return t("div",[t("el-dialog",{attrs:{title:"",visible:e.dialogVisible_1,width:"70%","append-to-body":""},on:{"update:visible":function(t){e.dialogVisible_1=t}}},[t("Upload")],1),t("el-dialog",{attrs:{title:"",visible:e.dialogVisible_2,width:"70%","append-to-body":""},on:{"update:visible":function(t){e.dialogVisible_2=t}}},[t("View")]),t("el-table",{staticStyle:{width:"100%"},attrs:{data:e.a}},[t("el-table-column",{attrs:{prop:"datatype",label:"技术资料列表",width:"500"}}),t("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(o){return[t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.upload()}}},[e._v("上传")]),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.download()}}},[e._v("下载")]),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.view()}}},[e._v("预览")]),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.edit()}}},[e._v("编辑")])]}}])})],1)],1)},N=[],P=(o(7658),function(){var e=this,t=e._self._c;return t("div",[t("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{action:"https://jsonplaceholder.typicode.com/posts/","on-preview":e.handlePreview,"on-remove":e.handleRemove,"file-list":e.fileList,"auto-upload":!1}},[t("el-button",{attrs:{slot:"trigger",size:"small",type:"primary"},slot:"trigger"},[e._v("选取文件")]),t("el-button",{staticStyle:{"margin-left":"10px"},attrs:{size:"small",type:"success"},on:{click:e.submitUpload}},[e._v("上传文件")])],1),t("el-form",{ref:"form",attrs:{model:e.file,inline:!0,rules:e.rules}},[t("el-form-item",{attrs:{label:"请选择所属科室",prop:"room_name"}},[t("div",[e.room[0]?t("pick",{attrs:{Options:e.room},model:{value:e.file.room_name,callback:function(t){e.$set(e.file,"room_name",t)},expression:"file.room_name"}}):e._e()],1)]),t("el-form-item",{attrs:{label:"图文档名称",prop:"file_name"}},[t("el-input",{model:{value:e.file.file_name,callback:function(t){e.$set(e.file,"file_name",t)},expression:"file.file_name"}})],1),t("el-form-item",{attrs:{label:"图文档编号",prop:"file_id"}},[t("el-input",{model:{value:e.file.file_id,callback:function(t){e.$set(e.file,"file_id",t)},expression:"file.file_id"}})],1),t("el-form-item",{attrs:{label:"创建工时",prop:"creator_work_hour"}},[t("el-input",{model:{value:e.file.creator_work_hour,callback:function(t){e.$set(e.file,"creator_work_hour",t)},expression:"file.creator_work_hour"}})],1),t("el-form-item",{attrs:{label:"请选择校对人",prop:"proof_person "}},[t("div",[e.room[0]?t("pick",{attrs:{Options:e.room},model:{value:e.file.proof_person,callback:function(t){e.$set(e.file,"proof_person",t)},expression:"file.proof_person"}}):e._e()],1)]),t("el-form-item",{attrs:{label:"请选择审核人",prop:"examine_person"}},[t("div",[e.room[0]?t("pick",{attrs:{Options:e.room},model:{value:e.file.examine_person,callback:function(t){e.$set(e.file,"examine_person",t)},expression:"file.examine_person"}}):e._e()],1)]),t("el-form-item",{attrs:{label:"请选择难度系数",prop:"difficulty_degree"}},[t("div",[t("el-radio",{attrs:{label:"1"},model:{value:e.file.difficulty_degree,callback:function(t){e.$set(e.file,"difficulty_degree",t)},expression:"file.difficulty_degree"}},[e._v("1")]),t("el-radio",{attrs:{label:"1.2"},model:{value:e.file.difficulty_degree,callback:function(t){e.$set(e.file,"difficulty_degree",t)},expression:"file.difficulty_degree"}},[e._v("1.2")]),t("el-radio",{attrs:{label:"1.5"},model:{value:e.file.difficulty_degree,callback:function(t){e.$set(e.file,"difficulty_degree",t)},expression:"file.difficulty_degree"}},[e._v("1.5")])],1)]),t("div",[t("el-form-item",{attrs:{label:"贡献度",prop:"contribute_degree"}},[t("el-input",{model:{value:e.file.contribute_degree,callback:function(t){e.$set(e.file,"contribute_degree",t)},expression:"file.contribute_degree"}})],1)],1),t("el-form-item",{attrs:{label:"请输入文档内容说明",prop:"file_desc"}},[t("el-input",{attrs:{type:"textarea",rows:5,placeholder:"请输入内容"},model:{value:e.file.file_desc,callback:function(t){e.$set(e.file,"file_desc",t)},expression:"file.file_desc"}})],1),t("div",[t("el-form-item",{attrs:{label:"请选择是否发布",prop:"is_publish"}},[t("div",[t("el-radio",{attrs:{label:"1"},model:{value:e.file.is_publish,callback:function(t){e.$set(e.file,"is_publish",t)},expression:"file.is_publish"}},[e._v("是")]),t("el-radio",{attrs:{label:"0"},model:{value:e.file.is_publish,callback:function(t){e.$set(e.file,"is_publish",t)},expression:"file.is_publish"}},[e._v("否")])],1)])],1),t("div",[t("el-form-item",{attrs:{label:"请选择是否供外",prop:"is_give_out"}},[t("el-radio",{attrs:{label:"1"},model:{value:e.file.is_give_out,callback:function(t){e.$set(e.file,"is_give_out",t)},expression:"file.is_give_out"}},[e._v("是")]),t("el-radio",{attrs:{label:"0"},model:{value:e.file.is_give_out,callback:function(t){e.$set(e.file,"is_give_out",t)},expression:"file.is_give_out"}},[e._v("否")])],1)],1),t("el-form-item",{attrs:{label:"供外生命周期",prop:"give_out_life"}},[t("el-input",{model:{value:e.file.give_out_life,callback:function(t){e.$set(e.file,"give_out_life",t)},expression:"file.give_out_life"}})],1)],1)],1)}),A=[],D={components:{pick:C},data(){return{room:[],file:{}}},methods:{submitUpload(){this.$refs.upload.submit()},handleRemove(e,t){console.log(e,t)},handlePreview(e){console.log(e)}},async created(){const{data:e}=await this.$http.get("http://yapi.smart-xwork.cn/mock/226692/postProject/room");this.room=e}},M=D,U=(0,h.Z)(M,P,A,!1,null,null,null),T=U.exports,R={},z=(0,h.Z)(R,c,u,!1,null,null,null),L=z.exports,E={props:["tabledata"],components:{Upload:T,View:L},data(){return{a:[],b:{datatype:""},dialogVisible_1:!1,dialogVisible_2:!1,tableData:this.tabledata.document_type}},methods:{upload(){this.dialogVisible_1=!0},view(){this.dialogVisible_2=!0},edit(){this.dialogVisible_1=!0}},created(){console.log(this.tableData);for(let e=0;e<this.tableData.length;e++)this.b={datatype:this.tableData[e]},this.a.push(this.b)}},J=E,q=(0,h.Z)(J,V,N,!1,null,null,null),F=q.exports;console.log("project:cookie"),console.log(a.Z.get("token"));var I={components:{ViewProject:_,ModifyProject:S,uploadDocument:F},data(){return{timer:"",department:[],room:[],edit:!1,thisRow:{},activeName:"first",dialogVisible:!1,dialogVisible_1:!1,dialogVisible_2:!1,form:{project_name:"",project_id:"",project_create:"",project_members:[],project_approves:[],document_type:[],contract_date:"",sale_manager:"",contract_money:"",design_manager:"",serve_person:[],receive_address:"",deliver_way:"",order_unit:"",receive_unit:"",arrive_station:"",mail:"",contact_people:"",contact_people_phone:"",fax:"",send_unit:"",time_dy:"",time_sb:"",send_condition:""},rules:{name:[{required:!0,message:"请输入姓名"}],project_id:[{required:!0,message:"请输入令号"}],department:[{required:!0,message:"请选择科室"}]},modeltype:0,tabledata:[],userform:{name:""},options:[],value:[],list:[],loading:!1,states:["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Indiana","Iowa","Kansas","Kentucky","Georgia","Hawaii","Idaho","Illinois","Louisiana","Maine","Maryland","Nebraska","Nevada","New Hampshire","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Washington","West Virginia","Wisconsin","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Wyoming"]}},methods:{uploadDocument(e){this.timer=(new Date).getTime(),this.dialogVisible_2=!0,this.thisRow=e},handleClick(e,t){console.log(e,t)},handleAdd(){this.timer=(new Date).getTime(),this.modeltype=1,this.dialogVisible=!0,this.thisRow={}},submit(){this.$refs.form.validate((e=>{e&&(this.modeltype,(0,n.Z)({url:"http://yapi.smart-xwork.cn/mock/226692/postProject/work",method:"post",data:this.form}).then((()=>{this.getList()})),this.form={},this.$refs.form.resetFields(),this.dialogVisible=!1)}))},getList(){(0,n.Z)({url:"http://yapi.smart-xwork.cn/mock/226692/project/work",method:"get"}).then((e=>(console.log(e.data),this.tabledata.unshift(e.data),e.data)))},handleDelete(e){this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{s({id:e.id}).then((()=>{this.$message({type:"success",message:"删除成功!"}),this.getList()}))})).catch((()=>{this.$message({type:"info",message:"已取消删除"})}))},async handleEdit(e){this.timer=(new Date).getTime(),this.thisRow=e,this.modeltype=1,this.dialogVisible=!0,this.form=JSON.parse(JSON.stringify(e))},projectInfo(e){this.timer=(new Date).getTime(),this.dialogVisible_1=!0,console.log(e),this.thisRow=e,this.form=JSON.parse(JSON.stringify(e))},onSubmit(){this.getList()},remoteMethod(e){""!==e?(this.loading=!0,setTimeout((()=>{this.loading=!1,this.options=this.list.filter((t=>t.label.toLowerCase().indexOf(e.toLowerCase())>-1))}),200)):this.options=[]}},async mounted(){(0,n.Z)({url:"http://yapi.smart-xwork.cn/mock/226692/project/work",method:"get"}).then((e=>(console.log(e.data),this.tabledata.unshift(e.data),e.data))),this.list=this.states.map((e=>({value:`value:${e}`,label:`label:${e}`})));const{data:e}=await this.$http.get("http://yapi.smart-xwork.cn/mock/226692/project/department");this.department=e;const{data:t}=await this.$http.get("http://yapi.smart-xwork.cn/mock/226692/project/room");this.room=t}},B=I,H=(0,h.Z)(B,i,r,!1,null,"15c788e4",null),W=H.exports},428:function(e,t,o){"use strict";var i=o(4471),r=o(6369),a=function(){var e=this,t=e._self._c;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},n=[],l={name:"App"},s=l,c=o(1001),u=(0,c.Z)(s,a,n,!1,null,null,null),d=u.exports,m=o(8499),p=o.n(m),f=o(2631),h=(o(8609),o(2959)),b=(o(1067),o(2163));o(1669),o(7264),o(190);r["default"].use(f.ZP);const _=[{path:"/",component:b["default"],name:"main",redirect:"/userinfo",children:[]},{path:"/login",component:h["default"],name:"login"}],v=new f.ZP({routes:_});var g=v,k=o(5211),y=o(7634),w=o.n(y);o(541);function x(e){const t=e.split("?")[1];return t?JSON.parse('{"'+decodeURIComponent(t).replace(/"/g,'\\"').replace(/&/g,'","').replace(/=/g,'":"')+'"}'):{}}let $=[];var C={getUserList:e=>{const{name:t,page:o=1,limit:i=20}=x(e.url);console.log("name:"+t,"page:"+o,"分页大小limit:"+i);const r=$.filter((e=>!t||-1!==e.name.indexOf(t)||-1!==e.number_1.indexOf(t))),a=r.filter(((e,t)=>t<i*o&&t>=i*(o-1)));return{code:2e4,count:r.length,list:a}},createUser:e=>{const{name:t,number_1:o,department:i,description:r}=JSON.parse(e.body);return console.log(JSON.parse(e.body)),$.unshift({id:w().Random.guid(),name:t,number_1:o,department:i,description:r}),{code:2e4,data:{message:"添加成功"}}},deleteUser:e=>{const{id:t}=JSON.parse(e.body);return t?($=$.filter((e=>e.id!==t)),{code:2e4,message:"删除成功"}):{code:-999,message:"参数不正确"}},batchremove:e=>{let{ids:t}=x(e.url);return t=t.split(","),$=$.filter((e=>!t.includes(e.id))),{code:2e4,data:{message:"批量删除成功"}}},updateUser:e=>{const{id:t,name:o,number_1:i,department:r,description:a}=JSON.parse(e.body);return $.some((e=>{if(e.id===t)return e.name=o,e.number_1=i,e.department=r,e.description=a,!0})),{code:2e4,data:{message:"编辑成功"}}}};w().mock("/api/user/add","post",C.createUser),w().mock("/api/user/edit","post",C.updateUser),w().mock("/api/user/del","post",C.deleteUser),w().mock(/api\/user\/getUser/,"get",C.getUserList);var j=o(680);r["default"].prototype.$http=i.Z,r["default"].config.productionTip=!1,r["default"].use(p()),g.beforeEach(((e,t,o)=>{const i=j.Z.get("token");i||"login"===e.name?i&&"login"===e.name?o({name:"workhome"}):o():o({name:"login"})})),new r["default"]({store:k.Z,router:g,render:e=>e(d),created(){k.Z.commit("addmenu",g)}}).$mount("#app")},5211:function(e,t,o){"use strict";o.d(t,{Z:function(){return l}});var i=o(6369),r=o(3822),a=(o(7658),o(680)),n={state:{menu:[],token:a.Z.get("token")?a.Z.get("token"):""},mutations:{setToken(e,t){e.token=t,a.Z.set("token",t)},delToken(e){e.token="",a.Z.remove("token")},setmenu(e,t){e.menu=t,a.Z.set("menu",JSON.stringify(t))},addmenu(e,t){if(!a.Z.get("menu"))return;const i=JSON.parse(a.Z.get("menu"));e.menu=i;const r=[];i.forEach((e=>{e.children?(e.children=e.children.map((e=>(e.component=()=>o(6968)(`./${e.url}`),e))),r.push(...e.children)):(e.component=()=>o(6968)(`./${e.url}`),r.push(e))})),r.forEach((e=>{t.addRoute("main",e)}))}}};i["default"].use(r.ZP);var l=new r.ZP.Store({modules:{tab:n}})},4471:function(e,t,o){"use strict";var i=o(4161),r=(o(5211),o(680));i.Z.interceptors.request.use((e=>(null!=r.Z.get("token")&&""!=r.Z.get("token")?e.headers.token=r.Z.get("token"):console.log("no token"),e)),(e=>(console.log("error in request"),Promise.reject(e)))),t["Z"]=i.Z},6968:function(e,t,o){var i={"./document":[1067],"./document.vue":[1067],"./login":[2959],"./login.vue":[2959],"./main":[2163],"./main.vue":[2163],"./publish":[1669],"./publish.vue":[1669],"./superuserinfo":[911,911],"./superuserinfo.vue":[911,911],"./tec":[7264],"./tec.vue":[7264],"./userinfo":[190],"./userinfo.vue":[190],"./workhome":[8609],"./workhome.vue":[8609]};function r(e){if(!o.o(i,e))return Promise.resolve().then((function(){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}));var t=i[e],r=t[0];return Promise.all(t.slice(1).map(o.e)).then((function(){return o(r)}))}r.keys=function(){return Object.keys(i)},r.id=6968,e.exports=r},2315:function(e,t,o){"use strict";e.exports=o.p+"img/user.36929a03.png"}},t={};function o(i){var r=t[i];if(void 0!==r)return r.exports;var a=t[i]={id:i,loaded:!1,exports:{}};return e[i].call(a.exports,a,a.exports,o),a.loaded=!0,a.exports}o.m=e,function(){o.amdO={}}(),function(){var e=[];o.O=function(t,i,r,a){if(!i){var n=1/0;for(u=0;u<e.length;u++){i=e[u][0],r=e[u][1],a=e[u][2];for(var l=!0,s=0;s<i.length;s++)(!1&a||n>=a)&&Object.keys(o.O).every((function(e){return o.O[e](i[s])}))?i.splice(s--,1):(l=!1,a<n&&(n=a));if(l){e.splice(u--,1);var c=r();void 0!==c&&(t=c)}}return t}a=a||0;for(var u=e.length;u>0&&e[u-1][2]>a;u--)e[u]=e[u-1];e[u]=[i,r,a]}}(),function(){o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,{a:t}),t}}(),function(){o.d=function(e,t){for(var i in t)o.o(t,i)&&!o.o(e,i)&&Object.defineProperty(e,i,{enumerable:!0,get:t[i]})}}(),function(){o.f={},o.e=function(e){return Promise.all(Object.keys(o.f).reduce((function(t,i){return o.f[i](e,t),t}),[]))}}(),function(){o.u=function(e){return"js/"+e+".af95c50f.js"}}(),function(){o.miniCssF=function(e){}}(),function(){o.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)}}(),function(){var e={},t="web:";o.l=function(i,r,a,n){if(e[i])e[i].push(r);else{var l,s;if(void 0!==a)for(var c=document.getElementsByTagName("script"),u=0;u<c.length;u++){var d=c[u];if(d.getAttribute("src")==i||d.getAttribute("data-webpack")==t+a){l=d;break}}l||(s=!0,l=document.createElement("script"),l.charset="utf-8",l.timeout=120,o.nc&&l.setAttribute("nonce",o.nc),l.setAttribute("data-webpack",t+a),l.src=i),e[i]=[r];var m=function(t,o){l.onerror=l.onload=null,clearTimeout(p);var r=e[i];if(delete e[i],l.parentNode&&l.parentNode.removeChild(l),r&&r.forEach((function(e){return e(o)})),t)return t(o)},p=setTimeout(m.bind(null,void 0,{type:"timeout",target:l}),12e4);l.onerror=m.bind(null,l.onerror),l.onload=m.bind(null,l.onload),s&&document.head.appendChild(l)}}}(),function(){o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})}}(),function(){o.nmd=function(e){return e.paths=[],e.children||(e.children=[]),e}}(),function(){o.p="/"}(),function(){var e={143:0};o.f.j=function(t,i){var r=o.o(e,t)?e[t]:void 0;if(0!==r)if(r)i.push(r[2]);else{var a=new Promise((function(o,i){r=e[t]=[o,i]}));i.push(r[2]=a);var n=o.p+o.u(t),l=new Error,s=function(i){if(o.o(e,t)&&(r=e[t],0!==r&&(e[t]=void 0),r)){var a=i&&("load"===i.type?"missing":i.type),n=i&&i.target&&i.target.src;l.message="Loading chunk "+t+" failed.\n("+a+": "+n+")",l.name="ChunkLoadError",l.type=a,l.request=n,r[1](l)}};o.l(n,s,"chunk-"+t,t)}},o.O.j=function(t){return 0===e[t]};var t=function(t,i){var r,a,n=i[0],l=i[1],s=i[2],c=0;if(n.some((function(t){return 0!==e[t]}))){for(r in l)o.o(l,r)&&(o.m[r]=l[r]);if(s)var u=s(o)}for(t&&t(i);c<n.length;c++)a=n[c],o.o(e,a)&&e[a]&&e[a][0](),e[a]=0;return o.O(u)},i=self["webpackChunkweb"]=self["webpackChunkweb"]||[];i.forEach(t.bind(null,0)),i.push=t.bind(null,i.push.bind(i))}();var i=o.O(void 0,[998],(function(){return o(428)}));i=o.O(i)})();
//# sourceMappingURL=app.b0bcd68f.js.map