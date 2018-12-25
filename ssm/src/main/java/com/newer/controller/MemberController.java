package com.newer.controller;


import com.newer.domain.Member;
import com.newer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping
    public List<Member> findAll(@RequestParam(value = "mname", required = false) String mname,
                                @RequestParam(value = "mcardno", required = false) String mcardno) {

        Map<String, Object> map = new HashMap<>();

        if (mname != null) {
            map.put("mname", "%" + mname + "%");
        }
        if (mcardno != null) {
            map.put("mcardno", "%" + mcardno + "%");
        }

        return memberService.findAll(map);
    }

    @DeleteMapping("/{mid}")
    public Map<String, Object> delete(@PathVariable("mid") int mid) {

        Map<String, Object> results = new HashMap<>();

        int count = memberService.deleteMember(mid);

        results.put("count", count);

        return results;
    }

    @GetMapping("/{mid}")
    public Member findById(@PathVariable("mid") int mid) {


        return memberService.findById(mid);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(Member member) {

        Map<String, Object> results = new HashMap<>();

        int count = memberService.updateMember(member);

        results.put("count", count);


        return results;
    }


}
