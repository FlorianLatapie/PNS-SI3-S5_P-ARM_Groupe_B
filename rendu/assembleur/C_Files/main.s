	.text
	.syntax unified
	.eabi_attribute	67, "2.09"
	.cpu	cortex-m0
	.eabi_attribute	6, 12
	.eabi_attribute	7, 77
	.eabi_attribute	8, 0
	.eabi_attribute	9, 1
	.eabi_attribute	34, 0
	.eabi_attribute	17, 1
	.eabi_attribute	20, 1
	.eabi_attribute	21, 1
	.eabi_attribute	23, 3
	.eabi_attribute	24, 1
	.eabi_attribute	25, 1
	.eabi_attribute	38, 1
	.eabi_attribute	18, 4
	.eabi_attribute	26, 2
	.eabi_attribute	14, 0
	.file	"main.c"
	.globl	run
	.p2align	1
	.type	run,%function
	.code	16
	.thumb_func
run:
	.fnstart
	.pad	#108
	sub	sp, #108
	@APP
	sub	sp, #508
	@NO_APP
	@APP
	sub	sp, #452
	@NO_APP
	b	.LBB0_1
.LBB0_1:
	b	.LBB0_2
.LBB0_2:
	b	.LBB0_3
.LBB0_3:
	b	.LBB0_4
.LBB0_4:
	b	.LBB0_5
.LBB0_5:
	movs	r0, #80
	str	r0, [sp, #44]
	b	.LBB0_6
.LBB0_6:
	b	.LBB0_7
.LBB0_7:
	movs	r0, #45
	str	r0, [sp, #44]
	b	.LBB0_8
.LBB0_8:
	b	.LBB0_9
.LBB0_9:
	b	.LBB0_10
.LBB0_10:
	movs	r0, #65
	str	r0, [sp, #44]
	b	.LBB0_11
.LBB0_11:
	b	.LBB0_12
.LBB0_12:
	b	.LBB0_13
.LBB0_13:
	movs	r0, #82
	str	r0, [sp, #44]
	b	.LBB0_14
.LBB0_14:
	b	.LBB0_15
.LBB0_15:
	b	.LBB0_16
.LBB0_16:
	movs	r0, #77
	str	r0, [sp, #44]
	b	.LBB0_17
.LBB0_17:
	b	.LBB0_18
.LBB0_18:
	b	.LBB0_19
.LBB0_19:
	movs	r0, #10
	str	r0, [sp, #44]
	b	.LBB0_20
.LBB0_20:
	b	.LBB0_21
.LBB0_21:
	b	.LBB0_22
.LBB0_22:
	b	.LBB0_23
.LBB0_23:
	b	.LBB0_24
.LBB0_24:
	b	.LBB0_25
.LBB0_25:
	b	.LBB0_26
.LBB0_26:
	b	.LBB0_27
.LBB0_27:
	b	.LBB0_28
.LBB0_28:
	movs	r0, #71
	str	r0, [sp, #44]
	b	.LBB0_29
.LBB0_29:
	b	.LBB0_30
.LBB0_30:
	movs	r0, #114
	str	r0, [sp, #44]
	b	.LBB0_31
.LBB0_31:
	b	.LBB0_32
.LBB0_32:
	b	.LBB0_33
.LBB0_33:
	movs	r0, #111
	str	r0, [sp, #44]
	b	.LBB0_34
.LBB0_34:
	b	.LBB0_35
.LBB0_35:
	b	.LBB0_36
.LBB0_36:
	movs	r0, #117
	str	r0, [sp, #44]
	b	.LBB0_37
.LBB0_37:
	b	.LBB0_38
.LBB0_38:
	b	.LBB0_39
.LBB0_39:
	movs	r0, #112
	str	r0, [sp, #44]
	b	.LBB0_40
.LBB0_40:
	b	.LBB0_41
.LBB0_41:
	b	.LBB0_42
.LBB0_42:
	movs	r0, #101
	str	r0, [sp, #44]
	b	.LBB0_43
.LBB0_43:
	b	.LBB0_44
.LBB0_44:
	b	.LBB0_45
.LBB0_45:
	movs	r0, #32
	str	r0, [sp, #44]
	b	.LBB0_46
.LBB0_46:
	b	.LBB0_47
.LBB0_47:
	b	.LBB0_48
.LBB0_48:
	movs	r0, #66
	str	r0, [sp, #44]
	b	.LBB0_49
.LBB0_49:
	b	.LBB0_50
.LBB0_50:
	b	.LBB0_51
.LBB0_51:
	ldr	r0, [sp, #52]
	movs	r1, #128
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_52
.LBB0_52:
	b	.LBB0_53
.LBB0_53:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_54
.LBB0_54:
	b	.LBB0_55
.LBB0_55:
	ldr	r0, [sp, #52]
	movs	r1, #64
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_56
.LBB0_56:
	b	.LBB0_57
.LBB0_57:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_58
.LBB0_58:
	b	.LBB0_59
.LBB0_59:
	ldr	r0, [sp, #52]
	movs	r1, #32
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_60
.LBB0_60:
	b	.LBB0_61
.LBB0_61:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_62
.LBB0_62:
	b	.LBB0_63
.LBB0_63:
	ldr	r0, [sp, #52]
	movs	r1, #16
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_64
.LBB0_64:
	b	.LBB0_65
.LBB0_65:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_66
.LBB0_66:
	b	.LBB0_67
.LBB0_67:
	ldr	r0, [sp, #52]
	movs	r1, #8
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_68
.LBB0_68:
	b	.LBB0_69
.LBB0_69:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_70
.LBB0_70:
	b	.LBB0_71
.LBB0_71:
	ldr	r0, [sp, #52]
	movs	r1, #4
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_72
.LBB0_72:
	b	.LBB0_73
.LBB0_73:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_74
.LBB0_74:
	b	.LBB0_75
.LBB0_75:
	ldr	r0, [sp, #52]
	movs	r1, #2
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_76
.LBB0_76:
	b	.LBB0_77
.LBB0_77:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_78
.LBB0_78:
	b	.LBB0_79
.LBB0_79:
	ldr	r0, [sp, #52]
	movs	r1, #1
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_80
.LBB0_80:
	b	.LBB0_81
.LBB0_81:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_82
.LBB0_82:
	b	.LBB0_83
.LBB0_83:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #8
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_84
.LBB0_84:
	b	.LBB0_85
.LBB0_85:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_86
.LBB0_86:
	b	.LBB0_87
.LBB0_87:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #16
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_88
.LBB0_88:
	b	.LBB0_89
.LBB0_89:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_90
.LBB0_90:
	b	.LBB0_91
.LBB0_91:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #24
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_92
.LBB0_92:
	b	.LBB0_93
.LBB0_93:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_94
.LBB0_94:
	b	.LBB0_95
.LBB0_95:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #25
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_96
.LBB0_96:
	b	.LBB0_97
.LBB0_97:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_98
.LBB0_98:
	b	.LBB0_99
.LBB0_99:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #26
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_100
.LBB0_100:
	b	.LBB0_101
.LBB0_101:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_102
.LBB0_102:
	b	.LBB0_103
.LBB0_103:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #27
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_104
.LBB0_104:
	b	.LBB0_105
.LBB0_105:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_106
.LBB0_106:
	b	.LBB0_107
.LBB0_107:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #28
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_108
.LBB0_108:
	b	.LBB0_109
.LBB0_109:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_110
.LBB0_110:
	b	.LBB0_111
.LBB0_111:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #29
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_112
.LBB0_112:
	b	.LBB0_113
.LBB0_113:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_114
.LBB0_114:
	b	.LBB0_115
.LBB0_115:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #30
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_116
.LBB0_116:
	b	.LBB0_117
.LBB0_117:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_118
.LBB0_118:
	b	.LBB0_119
.LBB0_119:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #31
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_120
.LBB0_120:
	b	.LBB0_121
.LBB0_121:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_122
.LBB0_122:
	b	.LBB0_123
.LBB0_123:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #23
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_124
.LBB0_124:
	b	.LBB0_125
.LBB0_125:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_126
.LBB0_126:
	b	.LBB0_127
.LBB0_127:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #15
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_128
.LBB0_128:
	b	.LBB0_129
.LBB0_129:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_130
.LBB0_130:
	b	.LBB0_131
.LBB0_131:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #14
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_132
.LBB0_132:
	b	.LBB0_133
.LBB0_133:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_134
.LBB0_134:
	b	.LBB0_135
.LBB0_135:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #13
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_136
.LBB0_136:
	b	.LBB0_137
.LBB0_137:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_138
.LBB0_138:
	b	.LBB0_139
.LBB0_139:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #12
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_140
.LBB0_140:
	b	.LBB0_141
.LBB0_141:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_142
.LBB0_142:
	b	.LBB0_143
.LBB0_143:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #11
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_144
.LBB0_144:
	b	.LBB0_145
.LBB0_145:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_146
.LBB0_146:
	b	.LBB0_147
.LBB0_147:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #10
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_148
.LBB0_148:
	b	.LBB0_149
.LBB0_149:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_150
.LBB0_150:
	b	.LBB0_151
.LBB0_151:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #9
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_152
.LBB0_152:
	b	.LBB0_153
.LBB0_153:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_154
.LBB0_154:
	b	.LBB0_155
.LBB0_155:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #17
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_156
.LBB0_156:
	b	.LBB0_157
.LBB0_157:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_158
.LBB0_158:
	b	.LBB0_159
.LBB0_159:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #18
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_160
.LBB0_160:
	b	.LBB0_161
.LBB0_161:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_162
.LBB0_162:
	b	.LBB0_163
.LBB0_163:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #19
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_164
.LBB0_164:
	b	.LBB0_165
.LBB0_165:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_166
.LBB0_166:
	b	.LBB0_167
.LBB0_167:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #20
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_168
.LBB0_168:
	b	.LBB0_169
.LBB0_169:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_170
.LBB0_170:
	b	.LBB0_171
.LBB0_171:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #21
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_172
.LBB0_172:
	b	.LBB0_173
.LBB0_173:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_174
.LBB0_174:
	b	.LBB0_175
.LBB0_175:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #22
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_176
.LBB0_176:
	b	.LBB0_177
.LBB0_177:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_178
.LBB0_178:
	b	.LBB0_179
.LBB0_179:
	ldr	r0, [sp, #52]
	movs	r1, #128
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_180
.LBB0_180:
	b	.LBB0_181
.LBB0_181:
	ldr	r0, [sp, #52]
	movs	r1, #64
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_182
.LBB0_182:
	b	.LBB0_183
.LBB0_183:
	ldr	r0, [sp, #52]
	movs	r1, #32
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_184
.LBB0_184:
	b	.LBB0_185
.LBB0_185:
	ldr	r0, [sp, #52]
	movs	r1, #16
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_186
.LBB0_186:
	b	.LBB0_187
.LBB0_187:
	ldr	r0, [sp, #52]
	movs	r1, #8
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_188
.LBB0_188:
	b	.LBB0_189
.LBB0_189:
	ldr	r0, [sp, #52]
	movs	r1, #4
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_190
.LBB0_190:
	b	.LBB0_191
.LBB0_191:
	ldr	r0, [sp, #52]
	movs	r1, #2
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_192
.LBB0_192:
	b	.LBB0_193
.LBB0_193:
	ldr	r0, [sp, #52]
	movs	r1, #1
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_194
.LBB0_194:
	b	.LBB0_195
.LBB0_195:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_196
.LBB0_196:
	b	.LBB0_197
.LBB0_197:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #15
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_198
.LBB0_198:
	b	.LBB0_199
.LBB0_199:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #14
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_200
.LBB0_200:
	b	.LBB0_201
.LBB0_201:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #13
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_202
.LBB0_202:
	b	.LBB0_203
.LBB0_203:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #12
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_204
.LBB0_204:
	b	.LBB0_205
.LBB0_205:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #11
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_206
.LBB0_206:
	b	.LBB0_207
.LBB0_207:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #10
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_208
.LBB0_208:
	b	.LBB0_209
.LBB0_209:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #9
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_210
.LBB0_210:
	b	.LBB0_211
.LBB0_211:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #8
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_212
.LBB0_212:
	b	.LBB0_213
.LBB0_213:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_214
.LBB0_214:
	b	.LBB0_215
.LBB0_215:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #23
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_216
.LBB0_216:
	b	.LBB0_217
.LBB0_217:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #22
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_218
.LBB0_218:
	b	.LBB0_219
.LBB0_219:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #21
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_220
.LBB0_220:
	b	.LBB0_221
.LBB0_221:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #20
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_222
.LBB0_222:
	b	.LBB0_223
.LBB0_223:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #19
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_224
.LBB0_224:
	b	.LBB0_225
.LBB0_225:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #18
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_226
.LBB0_226:
	b	.LBB0_227
.LBB0_227:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #17
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_228
.LBB0_228:
	b	.LBB0_229
.LBB0_229:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #16
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_230
.LBB0_230:
	b	.LBB0_231
.LBB0_231:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_232
.LBB0_232:
	b	.LBB0_233
.LBB0_233:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #31
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_234
.LBB0_234:
	b	.LBB0_235
.LBB0_235:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #30
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_236
.LBB0_236:
	b	.LBB0_237
.LBB0_237:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #29
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_238
.LBB0_238:
	b	.LBB0_239
.LBB0_239:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #28
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_240
.LBB0_240:
	b	.LBB0_241
.LBB0_241:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #27
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_242
.LBB0_242:
	b	.LBB0_243
.LBB0_243:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #26
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_244
.LBB0_244:
	b	.LBB0_245
.LBB0_245:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #25
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_246
.LBB0_246:
	b	.LBB0_247
.LBB0_247:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #24
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_248
.LBB0_248:
	b	.LBB0_249
.LBB0_249:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_250
.LBB0_250:
	movs	r0, #1
	str	r0, [sp, #20]
	movs	r0, #2
	str	r0, [sp, #16]
	ldr	r0, [sp, #20]
	ldr	r1, [sp, #16]
	adds	r0, r0, r1
	str	r0, [sp, #48]
	b	.LBB0_251
.LBB0_251:
	movs	r0, #10
	str	r0, [sp, #44]
	b	.LBB0_252
.LBB0_252:
	b	.LBB0_253
.LBB0_253:
	b	.LBB0_254
.LBB0_254:
	b	.LBB0_255
.LBB0_255:
	b	.LBB0_256
.LBB0_256:
	b	.LBB0_257
.LBB0_257:
	b	.LBB0_258
.LBB0_258:
	b	.LBB0_259
.LBB0_259:
	b	.LBB0_260
.LBB0_260:
	b	.LBB0_261
.LBB0_261:
	b	.LBB0_262
.LBB0_262:
	b	.LBB0_263
.LBB0_263:
	b	.LBB0_264
.LBB0_264:
	b	.LBB0_265
.LBB0_265:
	b	.LBB0_266
.LBB0_266:
	b	.LBB0_267
.LBB0_267:
	b	.LBB0_268
.LBB0_268:
	b	.LBB0_269
.LBB0_269:
	movs	r0, #108
	str	r0, [sp, #44]
	b	.LBB0_270
.LBB0_270:
	b	.LBB0_271
.LBB0_271:
	movs	r0, #97
	str	r0, [sp, #44]
	b	.LBB0_272
.LBB0_272:
	b	.LBB0_273
.LBB0_273:
	b	.LBB0_274
.LBB0_274:
	movs	r0, #110
	str	r0, [sp, #44]
	b	.LBB0_275
.LBB0_275:
	b	.LBB0_276
.LBB0_276:
	b	.LBB0_277
.LBB0_277:
	movs	r0, #99
	str	r0, [sp, #44]
	b	.LBB0_278
.LBB0_278:
	b	.LBB0_279
.LBB0_279:
	b	.LBB0_280
.LBB0_280:
	movs	r0, #101
	str	r0, [sp, #44]
	b	.LBB0_281
.LBB0_281:
	b	.LBB0_282
.LBB0_282:
	b	.LBB0_283
.LBB0_283:
	movs	r0, #109
	str	r0, [sp, #44]
	b	.LBB0_284
.LBB0_284:
	b	.LBB0_285
.LBB0_285:
	b	.LBB0_286
.LBB0_286:
	movs	r0, #101
	str	r0, [sp, #44]
	b	.LBB0_287
.LBB0_287:
	b	.LBB0_288
.LBB0_288:
	b	.LBB0_289
.LBB0_289:
	movs	r0, #110
	str	r0, [sp, #44]
	b	.LBB0_290
.LBB0_290:
	b	.LBB0_291
.LBB0_291:
	b	.LBB0_292
.LBB0_292:
	movs	r0, #116
	str	r0, [sp, #44]
	b	.LBB0_293
.LBB0_293:
	b	.LBB0_294
.LBB0_294:
	b	.LBB0_295
.LBB0_295:
	movs	r0, #32
	str	r0, [sp, #44]
	b	.LBB0_296
.LBB0_296:
	b	.LBB0_297
.LBB0_297:
	b	.LBB0_298
.LBB0_298:
	movs	r0, #100
	str	r0, [sp, #44]
	b	.LBB0_299
.LBB0_299:
	b	.LBB0_300
.LBB0_300:
	b	.LBB0_301
.LBB0_301:
	movs	r0, #117
	str	r0, [sp, #44]
	b	.LBB0_302
.LBB0_302:
	b	.LBB0_303
.LBB0_303:
	b	.LBB0_304
.LBB0_304:
	movs	r0, #32
	str	r0, [sp, #44]
	b	.LBB0_305
.LBB0_305:
	b	.LBB0_306
.LBB0_306:
	b	.LBB0_307
.LBB0_307:
	movs	r0, #106
	str	r0, [sp, #44]
	b	.LBB0_308
.LBB0_308:
	b	.LBB0_309
.LBB0_309:
	b	.LBB0_310
.LBB0_310:
	movs	r0, #101
	str	r0, [sp, #44]
	b	.LBB0_311
.LBB0_311:
	b	.LBB0_312
.LBB0_312:
	b	.LBB0_313
.LBB0_313:
	movs	r0, #117
	str	r0, [sp, #44]
	b	.LBB0_314
.LBB0_314:
	b	.LBB0_315
.LBB0_315:
	b	.LBB0_316
.LBB0_316:
	movs	r0, #10
	str	r0, [sp, #44]
	b	.LBB0_317
.LBB0_317:
	b	.LBB0_318
.LBB0_318:
	movs	r0, #0
	str	r0, [sp, #48]
	movs	r1, #1
	str	r1, [sp, #12]
	str	r1, [sp, #8]
	str	r0, [sp, #4]
	b	.LBB0_319
.LBB0_319:
	ldr	r0, [sp, #52]
	movs	r1, #1
	lsls	r1, r1, #24
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_320
.LBB0_320:
	b	.LBB0_321
.LBB0_321:
	b	.LBB0_322
.LBB0_322:
	ldr	r0, [sp, #12]
	movs	r1, #7
	subs	r0, r1, r0
	ldr	r1, [sp, #8]
	movs	r2, #3
	ands	r1, r2
	lsls	r1, r1, #3
	orrs	r0, r1
	movs	r1, #1
	lsls	r1, r0
	ldr	r0, [sp, #52]
	orrs	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_323
.LBB0_323:
	b	.LBB0_324
.LBB0_324:
	movs	r0, #1
	str	r0, [sp, #56]
	b	.LBB0_325
.LBB0_325:
	b	.LBB0_326
.LBB0_326:
	b	.LBB0_327
.LBB0_327:
	ldr	r0, [sp, #68]
	cmp	r0, #0
	bne	.LBB0_329
	b	.LBB0_328
.LBB0_328:
	b	.LBB0_327
.LBB0_329:
	b	.LBB0_330
.LBB0_330:
	ldr	r0, [sp, #72]
	str	r0, [sp]
	ldr	r0, [sp]
	str	r0, [sp, #4]
	b	.LBB0_331
.LBB0_331:
	ldr	r0, [sp, #12]
	movs	r1, #7
	subs	r0, r1, r0
	ldr	r1, [sp, #8]
	movs	r2, #3
	ands	r1, r2
	lsls	r1, r1, #3
	orrs	r0, r1
	movs	r1, #1
	lsls	r1, r0
	ldr	r0, [sp, #52]
	bics	r0, r1
	str	r0, [sp, #52]
	b	.LBB0_332
.LBB0_332:
	ldr	r0, [sp, #4]
	cmp	r0, #113
	bne	.LBB0_334
	b	.LBB0_333
.LBB0_333:
	ldr	r0, [sp, #12]
	subs	r0, r0, #1
	str	r0, [sp, #12]
	b	.LBB0_343
.LBB0_334:
	ldr	r0, [sp, #4]
	cmp	r0, #100
	bne	.LBB0_336
	b	.LBB0_335
.LBB0_335:
	ldr	r0, [sp, #12]
	adds	r0, r0, #1
	str	r0, [sp, #12]
	b	.LBB0_342
.LBB0_336:
	ldr	r0, [sp, #4]
	cmp	r0, #122
	bne	.LBB0_338
	b	.LBB0_337
.LBB0_337:
	ldr	r0, [sp, #8]
	subs	r0, r0, #1
	str	r0, [sp, #8]
	b	.LBB0_341
.LBB0_338:
	ldr	r0, [sp, #4]
	cmp	r0, #115
	bne	.LBB0_340
	b	.LBB0_339
.LBB0_339:
	ldr	r0, [sp, #8]
	adds	r0, r0, #1
	str	r0, [sp, #8]
	b	.LBB0_340
.LBB0_340:
	b	.LBB0_341
.LBB0_341:
	b	.LBB0_342
.LBB0_342:
	b	.LBB0_343
.LBB0_343:
	b	.LBB0_344
.LBB0_344:
	ldr	r0, [sp, #4]
	str	r0, [sp, #44]
	b	.LBB0_345
.LBB0_345:
	movs	r0, #0
	str	r0, [sp, #4]
	ldr	r0, [sp, #12]
	movs	r1, #7
	ands	r0, r1
	str	r0, [sp, #12]
	ldr	r0, [sp, #8]
	movs	r1, #3
	ands	r0, r1
	str	r0, [sp, #8]
	ldr	r0, [sp, #12]
	cmp	r0, #7
	bne	.LBB0_370
	b	.LBB0_346
.LBB0_346:
	ldr	r0, [sp, #8]
	cmp	r0, #3
	bne	.LBB0_370
	b	.LBB0_347
.LBB0_347:
	movs	r0, #10
	str	r0, [sp, #48]
	b	.LBB0_348
.LBB0_348:
	b	.LBB0_349
.LBB0_349:
	b	.LBB0_350
.LBB0_350:
	b	.LBB0_351
.LBB0_351:
	b	.LBB0_352
.LBB0_352:
	b	.LBB0_353
.LBB0_353:
	movs	r0, #10
	str	r0, [sp, #44]
	b	.LBB0_354
.LBB0_354:
	b	.LBB0_355
.LBB0_355:
	movs	r0, #103
	str	r0, [sp, #44]
	b	.LBB0_356
.LBB0_356:
	b	.LBB0_357
.LBB0_357:
	b	.LBB0_358
.LBB0_358:
	movs	r0, #97
	str	r0, [sp, #44]
	b	.LBB0_359
.LBB0_359:
	b	.LBB0_360
.LBB0_360:
	b	.LBB0_361
.LBB0_361:
	movs	r0, #103
	str	r0, [sp, #44]
	b	.LBB0_362
.LBB0_362:
	b	.LBB0_363
.LBB0_363:
	b	.LBB0_364
.LBB0_364:
	movs	r0, #110
	str	r0, [sp, #44]
	b	.LBB0_365
.LBB0_365:
	b	.LBB0_366
.LBB0_366:
	b	.LBB0_367
.LBB0_367:
	movs	r0, #101
	str	r0, [sp, #44]
	b	.LBB0_368
.LBB0_368:
	b	.LBB0_369
.LBB0_369:
	b	.LBB0_370
.LBB0_370:
	b	.LBB0_321
.Lfunc_end0:
	.size	run, .Lfunc_end0-run
	.cantunwind
	.fnend


	.ident	"clang version 8.0.1-3~bpo10+1 (tags/RELEASE_801/final)"
	.section	".note.GNU-stack","",%progbits
	.addrsig
	.eabi_attribute	30, 6
