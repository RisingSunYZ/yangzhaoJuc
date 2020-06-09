package com.yangzhao.designPattern.single;

public enum TAB{
        ZHU_HE_TONG("主合同","10",""),
        ZHU_HE_TONG_BU_CHONG("主合同补充协议","11",""),
        BAO_XIU("保修协议","20",""),
        BAO_XIU_BU_CHONG("保修协议补充协议","21",""),
        BEI_AN("备案合同","30",""),
        BEI_AN_BU_CHONG("备案合同补充协议","31",""),
        CONG_HE_TONG("从合同","40",""),
        CONG_HE_TONG_BU_CHONG("从合同补充协议","41",""),
        LABOUR_CONTRACT_TYPE("劳务合同","50","LW0"),
        LABOUR_BC_CONTRACT_TYPE("劳务合同补充协议","51","LW1"),
        MATERIAL_PURCHASE("材料采购合同","60","CL0"),
        MATERIAL_PURCHASE_BC("材料采购合同补充协议","61","CL1"),
        MATERIAL_PURCHASE_QP("全品销售合同","70","CL0"),
        MATERIAL_PURCHASE_QP_BC("全品销售合同补充协议","71","CL1"),
        MATERIAL_PURCHASE_GH("长期供货协议","80","CL0"),
        MATERIAL_PURCHASE_GH_BC("长期供货协议补充协议","81","CL1"),
        PROFESSIONAL_SUB_CONTRACT("专业分包合同","90","ZY0"),
        PROFESSIONAL_BC_SUB_CONTRACT("专业分包合同补充协议","91","ZY1"),
        MEASURES_SUB_CONTRACT("措施分包合同","100","CS0"),
        MEASURES_BC_SUB_CONTRACT("措施分包合同补充协议","101","CS1"),
        SECONDARY_CONTRACT("二次机电合同","110","CL0"),
        SECONDARY_BC_CONTRACT("二次机电补充协议","111","CL1"),
        JG_CONTRACT("通用合同","120","TY0"),
        MATERIAL_PURCHASE_QPMYCG("全品贸易采购合同","130","CL0"),
        MATERIAL_PURCHASE_QPMYCG_BC("全品贸易采购合同补充协议","131","CL1"),
        MATERIAL_PURCHASE_QPMYXS("全品贸易销售合同","140","CL0"),
        MATERIAL_PURCHASE_QPMYXS_BC("全品贸易销售合同补充协议","141","CL1"),
        JG_BC_CONTRACT("通用合同补充协议","121","TY1");


        public static String getTag(String key) {
            TAB[] valueTypes = values();
//            for (TAB valueType : valueTypes) {
//                if (valueType.dataKey.equals(key)) {
//                    String date = sdf.format(new Date());
//                    return date+valueType.dataTag();
//                }
//            }
            return null;
        }
        public static String getValue(String key) {
            TAB[] items = values();
            for (TAB item : items) {
                if (item.dataKey.equals(key)) {
                    return item.dataValue();
                }
            }
            return null;
        }
        private String dataValue;
        private String dataKey;
        private String dataTag;
        TAB(String dataValue,String dataKey,String dataTag) {
            this.dataValue = dataValue;
            this.dataKey = dataKey;
            this.dataTag = dataTag;
        }
        public String dataValue() {
            return dataValue;
        }
        public String dataKey() {
            return dataKey;
        }
        public String dataTag() {
            return dataTag;
        }
    }