sub sp, #12
movs r0, #0
str r0, [sp, #8]
movs r1, #1
str r1, [sp, #4]
ldr r1, [sp, #8]
ldr r2, [sp, #4]
adds r1, r1, r2
str r1, [sp]
add sp, #12