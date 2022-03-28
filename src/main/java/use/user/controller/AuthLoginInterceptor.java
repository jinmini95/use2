package use.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인처리를 담당하는 인터셉터
public class AuthLoginInterceptor extends HandlerInterceptorAdapter{

 // preHandle() : 컨트롤러보다 먼저 수행되는 메서드
 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {

     HttpSession session = request.getSession();

     System.out.println("여기들어오나?");
     Object obj = session.getAttribute("userId");
       
     if ( obj == null ){

         response.sendRedirect("../../index.jsp");
         return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
     }
     return true;
 }


 @Override
 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
     // TODO Auto-generated method stub
     super.postHandle(request, response, handler, modelAndView);
 }     
}