package com.java.admin.controller;

import com.java.admin.dto.DictionaryCode.AddItemDto;
import com.java.admin.dto.DictionaryCode.ModifyItemDto;
import com.java.admin.entity.DictionaryCode;
import com.java.admin.service.DictionaryCodeService;
import com.java.admin.utils.CustomException;
import com.java.admin.utils.R;
import com.java.admin.utils.ResponseEnum;
import com.java.admin.utils.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dictionaryCode")
@Api(tags = "字典编码管理")
public class DictionaryCodeController {

    @Autowired
    private DictionaryCodeService dictionaryCodeService;

    @PostMapping()
    @ApiOperation("新增")
    public R addItem(@RequestBody AddItemDto addObject) {
        DictionaryCode dictionaryCode = new DictionaryCode();
        dictionaryCode.setCode(addObject.getCode());
        dictionaryCode.setDescription(addObject.getDescription());
        dictionaryCode.setSort(addObject.getSort());
        this.dictionaryCodeService.save(dictionaryCode);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R deleteItem(@PathVariable String id) {
        this.dictionaryCodeService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R modifyItem(@PathVariable String id, @RequestBody ModifyItemDto putObject) {
        if (!new Integer(id).equals(putObject.getId())) {
            throw new CustomException(ResponseEnum.PARAMS_IS_NULL);
        }
        DictionaryCode dictionaryCode = new DictionaryCode();
        dictionaryCode.setCode(putObject.getCode());
        dictionaryCode.setDescription(putObject.getDescription());
        dictionaryCode.setSort(putObject.getSort());
        dictionaryCode.setId(putObject.getId());
        this.dictionaryCodeService.updateById(dictionaryCode);
        return R.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R getItem(@PathVariable String id) {
        return ResultVoUtil.success(this.dictionaryCodeService.getById(id));
    }
}
