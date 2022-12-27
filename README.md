# LeetCode
LeetCode刷题
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
模板配置:

![](img/image-20220324164003559.png)



Temp FilePath: .\LeetCode\src\main\java

Code Filename: [$!{question.frontendQuestionId}]${question.title}



CodeTemplete: 

 ${question.content}
package leetcode.editor.cn;

class $!velocityTool.camelCaseName(${question.titleSlug}){
  public static void main(String[] args) {
    Solution solution =  new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }

${question.code}
}