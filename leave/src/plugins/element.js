import { Aside, Breadcrumb, BreadcrumbItem, Button, Card, Col, Container, 
    Form, FormItem, Header, Input, Main, Menu, MenuItem, Message, Row, Submenu, Table, TableColumn,Dialog
 } from "element-ui";
import Vue from "vue/types/umd";




Vue.use(Button)
Vue.use(Form)

Vue.use(FormItem)
Vue.use(Input)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Card)
Vue.use(Row)
Vue.use(Col)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Dialog)

Vue.prototype.$message=Message